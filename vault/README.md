<!--query:toc-->
- Introduction
- Do's and don'ts
    - Do use version control
    - Do write notes in the daily log outline
    - Do clean up the daily log at the end of the day
    - Do use folders and don't use tags
    - Don't duplicate content manually
    - Do use front matter for metadata only
    - Don't maintain lists and tables manually
    - Do archive old material
    - Do use emojis in titles and sections
<!--/query (5b38ddb7)-->

## Introduction

This is the demo vault that accompanies the [[Markdown Curator Demo]] application. It's organized similarly to my own private vaults.

On the one hand this vault serves as an example of what the [[Markdown Curator]] can do. On the other hand, it shows how I keep notes and can serve as a template for your own vaults.

**Tip**: use [[Obsidian]] to edit this vault. You don't really have to. Any text editor will do. However [[Obsidian]] is a great fit.

When you run the demo application next to this vault, it will monitor changes to the files in it and run queries on the fly. Try it: add a section to this [[README]] and watch the table of contents at the top of this file automatically update.

## Do's and don'ts

Here are the guidelines I follow when writing notes.

### Do use version control

All content in a vault is plaintext. That's just perfect for a version control system like Git. I cannot recommend using it enough, especially when a separate tool like the [[Markdown Curator]] is monitoring and updating files in the vault in the background. In the odd case that it messes up the content, all you need to do is revert local changes.

### Do write notes in the daily log outline

[[Logseq]] taught me this. The rationale: thinking about where to put a certain piece of information before having written it is slow and error prone. You have to think about it. It's much easier to just open the daily log and start hacking away.

**Tip**: Obsidian's built-in "Daily notes" plugin allows you to set up a keyboard shortcut to open today's note. Mine is `Ctrl` + `Cmd` + `T`.

### Do clean up the daily log at the end of the day

If you write everything in the daily log outline, then you will end up logging some nuggets that you want to keep more front end center. Therefore, at the end of the day, have a look at the complete log for that day and refactor it by moving some information out of the log and into individual notes of projects, contacts, and so on.

### Do use folders and don't use tags

It's an age-old debate: should you use folders, tags, or both, to organize notes (or files in general)? Folders are one-dimensional, whereas tags are much more flexible. Choose your poison.

I've learned through trial and error that I need constraints, otherwise I make a mess of things. Too much flexibility makes me inconsistent because I can never remember my own system. It also makes me slow, because... I can never remember my own system. So I use a minimal amount of folders, and no tags. I use folders for two things:

1. **For categorization**. These are the top-level folders like "Contacts", "Journal", "Projects" and "Systems".
2. **For archiving**. Once a note has lost its relevancy, I move it into a subfolder "Archive/*YYYY*", where *YYYY* is the year. In practice this mostly applies to projects.

### Don't duplicate content manually



### Do use front matter for metadata only

Front matter (that YAML stuff at the top) is useful to store metadata, like tags and aliases, but once you start using it for more than metadata, you'll find yourself into a rabbit hole you can't get out of. 

Before you know it you're duplicating content.

### Don't maintain lists and tables manually



### Do archive old material



### Do use emojis in titles and sections
