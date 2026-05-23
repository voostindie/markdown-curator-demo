<!--query:toc-->
- Introduction
- How I manage projects from my journal
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
<!--/query (4c8055aa)-->
## Introduction

This is the demo vault that accompanies the [[Markdown Curator Demo]] application. It's organized similarly to my own private vaults.

On the one hand this vault serves as an example of what the [[Markdown Curator]] can do. On the other hand, it shows how I keep notes and can serve as a template for your own vaults.

**Tip**: use [[Obsidian]] to edit this vault. You don't really have to. Any text editor will do. However [[Obsidian]] is a great fit.

When you run the demo application next to this vault, it will monitor changes to the files in it and run queries on the fly. Try it: add a section to this [[README]] and watch the table of contents at the top of this file automatically update.

## How I manage projects from my journal

Take a look at the [[Meta Project]]. You will see a lot of content, but all of it is embedded within `<!--query-->` HTML lines, just like the table of contents in this README. The project also has properties. Where do the content and the properties come from? It comes from the *journal*, which is configured with *markers*.

Now take a look at the journal for [[2026-05-23]]. Its *Activities* section contains an outline. That's how I log my days. (See the do's and don'ts below for why a daily log makes sense.) In that outline you see something like this:

```markdown
- [[Meta Project]]
	- [[🎯]] Explain the use of markers to extract information from the journal and build complete project pages out of them.
	- [[📍]] Configurable markers, like '📍', tag lines in the journal. The rule is: the marker applies to the documents referenced in the outline one level up. In this case, that's the [[Meta Project]].
	- [[💁🏼|☝🏻]] [[Vincent Oostindië|I]] am the lead on this project.
	- [[🔗]] [voostindie/markdown-curator](https://github.com/voostindie/markdown-curator): the code for the [[Markdown Curator]].
	- [[🔗]] [voostindie/markdown-curator-demo](https://github.com/voostindie/markdown-curator-demo): this demo vault and the code for the application on top of it that does the magic.
	- [[⭕️|🟢]] All systems green!
```

Those emojis are actually links to notes. These are all notes in the `Markers` subfolder of the `Journal` folder. That makes them markers. I use emojis because I like how that looks. That's not necessary at all. Words work too. Or complete sentences. They don't even need to be at the start of the line; they just have to be in one.

Markers have one simple rule: they apply to the documents referenced in the line one level up in the outline. In this case that's [[Meta Project]]. 

Once you have put some a marker on a line, you can extract them from the journal through the `marked` query. The [[Meta Project]] contains the following query:

```markdown
<!--query:marked markers: [🎯, 📍, 💁🏼, 🔗, ⭕️]-->
<!--/query-->
```

This query states: pull all references to this project from the journal wherever these markers are used and give me a section for each marker, in the order they're declared in.

If you look carefully at the [[Meta Project]] note, you'll see that each section in the [[Meta Project]] has a title. This title comes from the marker configuration. For example, the marker [[🎯]] has its `title` property set to `Goals`.

The marker system is completely open. The vault itself defines which markers exist, how they look, and what they're used for.

But that's not all. The [[Meta Project]] also has front matter properties like `lead`, `last_modified` and `status`. The values of these properties are all pulled from the journal:

- The `last_modified` date is set to the most recent reference to the project.
- The `status` property is set to one of the supported aliases of the most recent [[⭕️]]  marker. See that marker for an explanation.
- The `lead` property is set to one of the supported aliases of the most recent [[💁🏼]] marker. See that marker for an explanation.

Again, this is an open system. You can configure it any way you like, in your own vault.

Having all these markers in place, it's possible to generate nice overviews, like this one:
<!--query:projects format: table-->

| Prio | Project                                | Lead                  | Last&nbsp;modified | Status |
| ---- | -------------------------------------- | --------------------- | ------------------ | ------ |
| -    | [[The do's and don't of note-keeping]] | -                     | [[2024-07-24]]     | ⚪️     |
| -    | [[Meta Project]]                       | [[Vincent Oostindië]] | [[2026-05-23]]     | 🟢     |

<!--/query (1a95ff70)-->
The project [[The do's and don't of note-keeping]] doesn't have any markers in the journal, which is why the `Lead` and `Status` columns have no useful value. You know how to fix that now!

The `Prio` column is also empty. There's two ways to fix that:

1. Define it in the `priority` property of the project note.
2. If you use [OmniFocus](https://www.omnigroup.com/omnifocus): enable the `OmniFocusModule` in the demo curator and pull the priorities from there. They sync up every 5 minutes.

## Do's and don'ts

Here are the guidelines I follow when writing notes.

### Do use version control

All content in a vault is plain text. That's just perfect for a version control system like Git. I cannot recommend using it enough, especially when a separate tool like the [[Markdown Curator]] is monitoring and updating files in the vault in the background. In the odd case that it messes up the content, all you need to do is revert local changes.

### Do write notes in the daily log outline

[[Logseq]] taught me this. The rationale: thinking about where to put a certain piece of information before having written it is slow and error-prone. It's much easier to just open the daily log and start hacking away.

**Tip 1**: Obsidian's built-in "Daily notes" plugin allows you to set up a keyboard shortcut to open today's note. Mine is `Ctrl` + `Cmd` + `T`.

**Tip 2**: Next to the built-in "Daily notes" plugin, there's also a community-provided "Periodic Notes" plugin. It's compatible and adds much more, like Weekly notes. I use that one.

**Tip 3**: The "Calendar" plugin is indispensable too.

### Do clean up the daily log at the end of the day

If you write everything in the daily log outline, then you will end up logging some nuggets that you want to keep more front end center. Therefore, at the end of the day, have a look at the complete log for that day and refactor it by moving some information out of the log and into individual notes of projects, contacts, and so on. Or, alternatively, you can mark these nuggets, and then automatically have them pulled into separate sections using the `marked` query.

### Do use folders and don't use tags

It's an age-old debate: should you use folders, tags, or both, to organize notes (or files in general)? Folders are one-dimensional, whereas tags are much more flexible. Choose your poison.

I've learned through trial and error that I need constraints, otherwise I make a mess of things. Too much flexibility makes me inconsistent because I can never remember my own system. It also makes me slow, because... I can never remember my own system. So I use a minimal amount of folders, and no tags. I use folders for two things:

1. **For categorization**. These are the top-level folders like "Contacts", "Journal", "Projects" and "Systems".
2. **For archiving**. Once a note has lost its relevancy, I move it into a subfolder "*YYYY*", where *YYYY* is the year. In practice this mostly applies to projects.

### Don't duplicate content manually

If you copy-paste content, you can be sure of one thing: at some point you'll change one, and not the other. Therefore, minimize the amount of copying you do. I created the [[Markdown Curator]] for this purpose: it copies and pastes for you, and ensures the copy is always in sync.
### Do use front matter for metadata only

Front matter (that YAML stuff at the top) is useful to store metadata, like tags and aliases, but once you start using it for more than metadata, you'll find yourself into a rabbit hole you can't get out of. 

Before you know it you're duplicating content.

Instead of putting data in formats to help the system, pick a system that uses your format!

Did you know that the [[Markdown Curator]] can generate front matter out of content? See the [[Meta Project]] for an example.

### Don't maintain lists and tables manually

This is a specialization of [[#Don't duplicate content manually]]. Lists are much easier generated and kept up to date automatically, than maintained by hand. Try the `toc`, `list` and `table` queries first. Or roll your own based on these.

### Do use emojis in titles and sections

Visuals are important. Using emojis in titles and sections is an easy way to spruce up your content and make it easily recognizable. In my case:

- I prefix titles with one of a small subset of emojis to categorize projects, teams and so on.
- I prefix sections for often-used sections - timeline, log, context, contacts, and so on - with fixed emojis, to make them easier to spot.

(I did not do that in this demo vault on purpose. I don't want to scare people off.)

## Available queries

Below is a reference to a non-existent query `name`, which means its output is replaced with an overview of all available queries:

<!--query:name-->
### Error

Queries available in this vault are:

- **daynav**: Generates calendar navigation in the daily journal
- **help**: Shows detailed help information for a query.
- **latestnav**: Generates a link to the latest journal entry
- **list**: Generates a sorted list of pages in a folder.
- **marked**: Generates an overview of the marked lines for the selected document, with entries extracted from the journal. Each marker gets its own section. The title of the section defaults to the name of the marker, but this can be overruled by setting the 'title' property of the marker document itself (if present). If a marker is not present for the selected document, the section is left out.
- **period**: Generates an overview of notes referenced by daily notes in a certain period
- **projectlead**: Outputs all active projects lead by a specific contact.
- **projects**: outputs all active projects
- **statistics**: Generates statistics on the vault in YAML format.
- **table**: Generates a sorted table of pages, with optional front matter fields in additional columns.
- **timeline**: Generates a timeline for the selected document, with entries extracted from the journal, newest entry first
- **toc**: Outputs a table of contents for the current document.
- **weekly**: Generates a weekly overview of activities, extracted from the journal
- **weeknav**: Generates calendar navigation in the weekly journal

Use the 'help' query to get more information on a specific query.
<!--/query (dabb5234)-->
