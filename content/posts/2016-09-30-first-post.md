---
layout: post
keywords: grain, groovy, sysgears
title: "First Post and the Grain Framework"
date: "2016-09-30 21:00"
icon: fa fa-sticky-note
categories: [grain, groovy]
comments: true   #disables/enables comments section for the post
published: true
---
###Greetings!
Hello World and welcome to my blog. This is the first post out of many that are yet to come (I hope).
<!--more-->

<center>
${img src: 'https://media.giphy.com/media/dzaUX7CAG0Ihi/giphy.gif', alt: 'email image', title: 'Hello'}
</center>

###How I decided to make this blog
Well there is a new trend around about static site generating that's supposed to set up a simple blog/website for everyone in just a few minutes.
All the cool kids use it nowadays. So after reading about the benefits I thought this was a great idea and went for it.

###What is a static site generator
A static site generator is software that translates content from a text format into HTML and creates consistent look and feel across all the pages. Usually one
can write posts in [Markdown] or [AsciiDoc] which is then converted into an HTML snippet, and then put into a larger HTML page. After generation, the resulted html
files can be copied (deployed) to any basic webserver (even in your dropbox) that serves the plain HTML.

###What are the benefits of static site generation
Static site generators are popular within the technical crowd. They take the complexity off of the server (no database! no caching!)
and put it on our local machine. Having just plain HTML makes the site more secure than traditional blogging platforms. It's hard to do an sql injection
or similar types of attacks as there is no database involved most of the times, and you don't have to worry about the latest PHP security updates 
it's all just plain HTML, CSS, and JavaScript man!

###Which static site generator to choose
Well that's a tough one. There are too many great tools out there which can do the same job more or less. You can compare all of them [here][staticgen]
The most popular one is [Jekyll]. [Hugo] is another one very good as well. But I didn't go with neither of these. I chose my generator based on my priorities and needs.

<center>
${img src: 'https://raw.githubusercontent.com/sysgears/grain/master/banner.png', alt: 'Grain Framework', title: 'Grain Framework', width: 800, height: 350}
</center>

###Going with Grain
What made me choose [Grain] as my primary static generator? Well I'm a fan of cross platform solutions and Jekyll [is not officially supported][JekyllWindows] as 
cross platform. Although you could make it work on Windows (my Main OS) using 3rd party dependencies like [Chocolatey] and executing it via commands like 
`bundle exec jekyll build` but Meh that seemed like too much hassle for me. I'm a java developer myself so why can't I find a real cross platform static generator
made in Java or at least some other JVM language? Plus I am already familiar with [Groovy] language so why spending time learning a new template language from
scratch like Jekyll-liquid when there is already [Groovy template support] out there?

That's what I did. And My first choice was [JBake]. JBake is promoted as the _"Jekyll of the JVM"_ &nbsp;but I soon realized it was nothing like that. 
I found myself struggling doing fundamental blogging actions. So I ditched it and after some further digging I ended up with [Grain]. 
Grain is an amazing piece of technology made by [SysGears]. It uses [Groovy] as its primary language and it's also cross platform. Some other features include:

<ul><ul type="disc">
<li>preview mode that allows to make and see changes on the fly</li>
<li>support of embedded Groovy code for any content files (including stylesheet and JS files)</li>
<li>configurable conventions that allow to process content sources using Groovy code</li>
<li>Markdown, reStructuredText and AsciiDoctor markup support</li>
<li>code highlighting via Python Pygments</li>
<li>built-in SASS/SCSS support</li>
<li>compression and minification for sources</li>
</ul></ul>

Sadly there are not many ready-to-use themes in Grain So I had to make one on my own. It felt like I almost started doing everything from scracth by converting 
a few Jekyll themes into Grain, however I learned a lot out of this process and I must say that the SysGear Guys were always willing to help me in every difficulty
I encountered.

So here I am! And Welcome to my new blog.

[SysGears]: http://sysgears.com/
[JBake]: http://jbake.org/
[Groovy template support]: http://docs.groovy-lang.org/latest/html/documentation/template-engines.html
[Groovy]: http://www.groovy-lang.org/
[Chocolatey]: https://chocolatey.org/
[JekyllWindows]: https://jekyllrb.com/docs/windows/
[Markdown]: http://daringfireball.net/projects/markdown/
[AsciiDoc]: http://www.methods.co.nz/asciidoc/
[Jekyll]: https://jekyllrb.com/
[Hugo]: https://gohugo.io/
[staticgen]: https://www.staticgen.com/
[SysGears]: http://sysgears.com/
[Grain]: http://sysgears.com/grain/