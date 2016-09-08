package com.sysgears.theme.taglib

import com.sysgears.grain.taglib.GrainTagLib

class ThemeTagLib {

    /**
     * Grain taglib reference.
     */
    private GrainTagLib taglib

    public ThemeTagLib(GrainTagLib taglib) {
        this.taglib = taglib
    }

    /**
     * Converts a date to XML date time format: 2013-12-31T12:49:00+07:00
     *
     * @attr date the date to convert
     */
    def xmlDateTime = { Map model ->
        if (!model.date) throw new IllegalArgumentException('Tag [xmlDateTime] is missing required attribute [date]')

        def tz = String.format('%tz', model.date)

        String.format("%tFT%<tT${tz.substring(0, 3)}:${tz.substring(3)}", model.date)
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
}
