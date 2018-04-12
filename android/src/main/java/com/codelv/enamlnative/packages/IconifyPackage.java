package com.codelv.enamlnative.packages;

import com.codelv.enamlnative.EnamlActivity;
import com.codelv.enamlnative.EnamlPackage;
import com.codelv.enamlnative.adapters.EnamlNativeIconFontDescriptor;
import com.joanzapata.iconify.Iconify;

import java.util.ArrayList;
import java.util.List;
//import com.joanzapata.iconify.fonts.EntypoModule;
//import com.joanzapata.iconify.fonts.FontAwesomeModule;
//import com.joanzapata.iconify.fonts.IoniconsModule;
//import com.joanzapata.iconify.fonts.MaterialCommunityModule;
//import com.joanzapata.iconify.fonts.MaterialModule;
//import com.joanzapata.iconify.fonts.MeteoconsModule;
//import com.joanzapata.iconify.fonts.SimpleLineIconsModule;
//import com.joanzapata.iconify.fonts.TypiconsModule;
//import com.joanzapata.iconify.fonts.WeathericonsModule;


/**
 * Created by jrm on 10/15/17.
 */
public class IconifyPackage implements EnamlPackage {
    static IconifyPackage mInstance;
    Iconify.IconifyInitializer mIconify;
    List<String> mCache = new ArrayList<String>();

    @Override
    public void onCreate(EnamlActivity activity) {
        mInstance = this;
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroy() {

    }

    /**
     * Add an IconPack
     * @param ttfFile
     * @param icons
     * @param characters
     */
    public static void addIconPack(String ttfFile, String[] icons, String characters) {
        if (mInstance==null) {
            throw new RuntimeException("Not ready!");
        }
        IconifyPackage self = mInstance;
        if (self.mCache.contains(ttfFile)) {
            return; // This is already loaded
        }
        self.mCache.add(ttfFile);

        Iconify.IconifyInitializer iconify = self.mIconify;
        EnamlNativeIconFontDescriptor d = new EnamlNativeIconFontDescriptor(ttfFile, icons,
                characters.toCharArray());

        if (iconify==null) {
            self.mIconify = Iconify.with(d);
        } else {
            iconify.with(d);
        }
    }

}
