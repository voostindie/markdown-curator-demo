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
    - Do use emojis in titles and sections
- Available queries
<!--/query (31912f39)-->

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

[[Logseq]] taught me this. The rationale: thinking about where to put a certain piece of information before having written it is slow and error-prone. It's much easier to just open the daily log and start hacking away.

**Tip**: Obsidian's built-in "Daily notes" plugin allows you to set up a keyboard shortcut to open today's note. Mine is `Ctrl` + `Cmd` + `T`.

### Do clean up the daily log at the end of the day

If you write everything in the daily log outline, then you will end up logging some nuggets that you want to keep more front end center. Therefore, at the end of the day, have a look at the complete log for that day and refactor it by moving some information out of the log and into individual notes of projects, contacts, and so on. Or, alternatively, you can mark these nuggets, and then automatically have them pulled into separate sections using the `marked` query.

### Do use folders and don't use tags

It's an age-old debate: should you use folders, tags, or both, to organize notes (or files in general)? Folders are one-dimensional, whereas tags are much more flexible. Choose your poison.

I've learned through trial and error that I need constraints, otherwise I make a mess of things. Too much flexibility makes me inconsistent because I can never remember my own system. It also makes me slow, because... I can never remember my own system. So I use a minimal amount of folders, and no tags. I use folders for two things:

1. **For categorization**. These are the top-level folders like "Contacts", "Journal", "Projects" and "Systems".
2. **For archiving**. Once a note has lost its relevancy, I move it into a subfolder "Archive/*YYYY*", where *YYYY* is the year. In practice this mostly applies to projects.

### Don't duplicate content manually

If you copy-paste content, you can be sure of one thing: at some point you'll change one, and not the other. Therefore, minimize the amount of copying you do. I created the [[Markdown Curator]] for this purpose: it copies and pastes for you, and ensures the copy is always in sync.
### Do use front matter for metadata only

Front matter (that YAML stuff at the top) is useful to store metadata, like tags and aliases, but once you start using it for more than metadata, you'll find yourself into a rabbit hole you can't get out of. 

Before you know it you're duplicating content.

Instead of putting data in formats to help the system, pick a system that uses your format!

### Don't maintain lists and tables manually

This is a specialization of [[#Don't duplicate content manually]]. Lists are much easier generated and kept up to date automatically, than maintained by hand. Try the `toc`, `list` and `table` queries first. Or roll your own based on these.

### Do use emojis in titles and sections

Visuals are important. Using emojis in titles and sections is an easy way to spruce up your content and make it easily recognizable. In my case:

- I prefix titles with one of a small subset of emojis to categorize projects, teams and so on.
- I prefix sections for often-used sections - timeline, log, context, contacts, and so on - with fixed emojis, to make them easier to spot.

## Available queries

Below is a reference to a query without a name, which means its output is replaced with an overview of all available queries:

<!--query-->
### Error

Queries available in this vault are:

- **daynav**: Generates calendar navigation in the daily journal
- **help**: Shows detailed help information for a query.
- **list**: Generates a sorted list of pages in a folder.
- **marked**: Generates an overview of the marked lines for the selected document, with entries extracted from the journal. Each marker gets its own section. The title of the section defaults demoto the name of the marker, but this can be overruled by setting the 'title' property of the marker document itself (if present). If a marker is not present for the selected document, the section is left out.
- **period**: Generates an overview of notes touched in a certain period, extracted from the journal
- **table**: Generates a sorted table of pages, with optional front matter fields in additional columns.
- **timeline**: Generates a timeline for the selected document, with entries extracted from the journal, newest entry first
- **toc**: Outputs a table of contents for the current document.
- **weekly**: Generates a weekly overview of activities, extracted from the journal
- **weeknav**: Generates calendar navigation in the weekly journal

Use the 'help' query to get more information on a specific query.
<!--/query (38eb3bf8)-->
