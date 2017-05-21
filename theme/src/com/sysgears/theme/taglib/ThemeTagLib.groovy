package com.sysgears.theme.taglib

import com.sysgears.grain.taglib.GrainTagLib

import java.text.DateFormat

class ThemeTagLib {

    /**
     * Grain taglib reference.
     */
    private GrainTagLib taglib

    public ThemeTagLib(GrainTagLib taglib) {
        this.taglib = taglib
    }

    /**
     * Converts markdown text to HTML.
     */
    def markdown = { String markdown ->
        String html = [source: markdown ?: "None", markup: 'md'].render().toString()
        html.replaceAll(/(?s)^<p>(.*)<\/p>$/, '$1')
    }

    /**
     * Loads configuration bundle represented by .yml files from the specified location.
     */
    def loadConfigBundle = { String location ->
        new File(taglib.site.content_dir as String, location).eachFileMatch(~/.*\.yml$/) { file ->
            taglib.page += taglib.site.headerParser.parse(file, file.text)
        }
    }

    /**
     * Converts a date to default locale full date time format.
     *
     * @attr date the date to convert
     */
    def fullDateTime = { Map model ->
        if (!model.date) throw new IllegalArgumentException('Tag [fullDateTime] is missing required attribute [date]')

        DateFormat.getDateInstance(DateFormat.FULL).format(date)
    }
}
