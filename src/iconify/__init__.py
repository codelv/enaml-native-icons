"""
Copyright (c) 2018, Jairus Martin.

Distributed under the terms of the MIT License.

The full license is in the file LICENSE, distributed with this software.

Created on April 11, 2018

@author
"""
import importlib
from atom.api import set_default
from enamlnative.android.bridge import JavaBridgeObject, JavaStaticMethod

DEFAULT_ICON_PACKS = [
    'iconify.material',
    'iconify.material_community',
]

BUILTIN_ICON_PACKS = [
    'iconify.cryptocoins',
    'iconify.entypo',
    'iconify.fontawesome',
    'iconify.ionicons',
    'iconify.material',
    'iconify.material_community',
    'iconify.meteocons',
    'iconify.simplelineicons',
    'iconify.typicons',
    'iconify.weathericons',
]


def install(*icon_packs):
    """ Install the icons from the given modules. A module is simply
    a python file with a SOURCE that points to the ttf file and ICONS
    that is the icon name to character mapping.
    
    Parameters
    ----------
    icon_packs: List
        List of paths to the modules to load. Each module must have a
        SOURCE attribute set to a `.ttf` file path and an ICON dictionary
        containing the mapping of icon name to character within the font pack.
        
        If empty the default's will be installed.
    
    """
    if not icon_packs:
        icon_packs = DEFAULT_ICON_PACKS
    for icon_pack in icon_packs:
        mod = importlib.import_module(icon_pack)
        IconifyPackage.addIconPack(mod.SOURCE,
                                   mod.ICONS.keys(),
                                   u"".join(mod.ICONS.values()))


class IconifyPackage(JavaBridgeObject):
    __nativeclass__ = set_default(
        'com.codelv.enamlnative.packages.IconifyPackage')

    addIconPack = JavaStaticMethod('java.lang.String',
                                   '[Ljava.lang.String;',
                                   'java.lang.String')

