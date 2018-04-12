package com.codelv.enamlnative.adapters;

import com.joanzapata.iconify.IconFontDescriptor;
import com.joanzapata.iconify.Icon;
import java.util.Map;
import java.util.HashMap;

/**
 * An IconFontDescriptor defines a TTF font file
 * and is able to map keys with characters in this file.
 */
public class EnamlNativeIconFontDescriptor implements IconFontDescriptor {
    protected String mFileName;
    protected Icon[] mIcons;

    class EnamlNativeIcon implements Icon {
        char mCharacter;
        String mName;

        EnamlNativeIcon(String name, char character) {
            mName = name;
            mCharacter = character;
        }

        @Override
        public String key() {
            return mName;
        }

        public char character() {
            return mCharacter;
        }
    }

    /**
     * Create a font from the filename and a dictionary with mapping {icon-name:character}
     * @param fileName
     * @param glyphs
     */
    public EnamlNativeIconFontDescriptor(String fileName, String[] names, char[] characters) {
        mFileName = fileName;
        mIcons = new Icon[names.length];

        // Build the icon pack
        for (int i=0; i<names.length; i++) {
            mIcons[i] = new EnamlNativeIcon(names[i], characters[i]);
        }
    }

    /**
     * The TTF file name.
     * @return a name with no slash, present in the assets.
     */
    @Override
    public String ttfFileName() {
        return mFileName;
    }

    @Override
    public Icon[] characters() {
        return mIcons;
    }

}
