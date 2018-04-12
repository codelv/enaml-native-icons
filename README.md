# enaml-native-icons

Iconfiy icons for enaml-native. 

This originally used [android-iconify](https://github.com/JoanZapata/android-iconify). Now instead
of requiring icon packs from java it has a python api to load icons from python.

### Usage

Install using the [enaml-native-cli](https://github.com/codelv/enaml-native-cli)

```bash

#: Using the enaml-native cli
enaml-native install enaml-native-icons

```

Then call `iconify.install` with the icon packs you want to use (or leave blank to use all the
builtin icon packs).

> Note: You must do this _after_ the Application is created in `main()` and _before_ the view is 
loaded in `load_view(app)`. Generally the begging

```python

def load_view(app):
    import enaml
    
    # Add icon packs here
    import iconify
    iconify.install() # defaults are material and material_community icons
    
    # Or you can pass in icons to use
    # iconify.install('iconify.icons.fontawesome', 'iconify.icons.weathericons')

    with enaml.imports():
        import view
        if app.view:
            reload(view)
        app.view = view.ContentView()
    
    app.show_view()

```

### Custom icon packs

You can now add your own icon packs and load them as is done above.

1. Download the `font.ttf`
2. Copy it into android's assets folder `android/app/src/main/assets/iconify` (
create the `assets` folders as needed)
3. Create a python icon pack module for the font. It is simply a module with `SOURCE` and `ICONS` 
variables. `SOURCE` is the path relative to the assets folder where your `.ttf` file is. `ICONS`
is a dict that maps the icon-name (string) to font character (typically unicode).
See the ones included here under `src/iconify/icons` for examples.

```python

# You can add your own packs and use the defaults 
iconify.install('cryptocoin', *iconify.DEFAULT_ICON_PACKS)

```

> Note: The ICON mapping can be parsed from `font.css` that is usually included with the font.
Just make a script parses all the ".class:begin{content:'\Exxxx'}" fields.