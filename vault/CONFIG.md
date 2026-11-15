This configures the [[Markdown Curator]] that is monitoring this vault. The curator is completely dynamic: change the configuration here, wait a few seconds, and watch the new configuration become active. No restarts required.

Here's the configuration:

```yaml
delay: 3
locale: en-US
extensions:
    journal:
        folder: Journal
        markers-folder: Markers
        activities-section: Activities
        projects-folder: Projects
    backlinks:
    project:
        folder: Projects
    projectjournal:
    alfred:
        projects-path: Projects
```

The delay and locale shown above have their default values; you can leave them out.

Here's the active configuration, including the status for each of the available extensions, the list of available queries, and the available output formats.

<!--query:configuration-->
### Settings

- **delay**: 3 seconds (default)
- **locale**: en-US (English (United States)) (default)

### Extensions

- 🟢 **alfred**: Exposes curator settings and external links to the Alfred workflow.
    - requires: Journal
    - settings:
        - `contacts-path`: Folder with contacts.
        - `links-section`: Section in documents with external links; defaults to `Links`.
        - `projects-path`: Folder with projects.
        - `reminders-path`: Folder with reminders.
        - `systems-path`: Folder with systems.
        - `teams-path`: Folder with teams.
        - `third-parties-path`: Folder with third parties.
- 🟢 **journal**: Journal extracted from daily notes, with markers, timelines and navigation.
    - provides: Journal
    - settings:
        - `activities-section`: Section in daily notes with activities; defaults to `Activities`.
        - `folder`: Folder with daily and weekly notes; defaults to `Journal`.
        - `markers-folder`: Subfolder of the journal folder with markers; defaults to `Markers`.
        - `projects-folder`: Folder with project documents; defaults to `Projects`.
- ⚪️️**omnifocus**: Compares projects in the vault with projects in OmniFocus.
    - requires: ProjectRepository
    - settings:
        - `database`: Path to the OmniFocus database; defaults to the OmniFocus 4 location.
        - `exclude`: List of names of OmniFocus projects to ignore.
        - `exclude-prefixes`: List of prefixes of OmniFocus projects to ignore.
        - `folder`: Folder in OmniFocus with the projects; required.
- 🟢 **project**: Projects, one document per project, with pluggable attributes.
    - provides: ProjectAttributeRepository, ProjectRepository
    - settings:
        - `folder`: Folder with project documents; defaults to `Projects`.
- 🟢 **projectjournal**: Resolves the lead, status and last modification date of projects from the journal.
    - requires: Journal, ProjectRepository

### Queries

- **alfred**: Output settings for the Alfred workflow
- **configuration**: Shows the curator settings, all available extensions with their status and dependencies, and all available queries and output formats.
- **daynav**: Generates calendar navigation in the daily journal
- **export**: Exports a document to vanilla Markdown.
- **help**: Shows detailed help information for a query.
- **latestnav**: Generates a link to the latest journal entry
- **links**: Gathers all external links for a document, for use in the HTTP server only.
- **list**: Generates a sorted list of pages in a folder.
- **ls**: Lists folder content
- **marked**: Generates an overview of the marked lines for the selected document, with entries extracted from the journal. Each marker gets its own section. The title of the section defaults to the name of the marker, but this can be overruled by setting the 'title' property of the marker document itself (if present). If a marker is not present for the selected document, the section is left out.
- **period**: Generates an overview of notes referenced by daily notes in a certain period
- **processorgraph**: Generates a Mermaid diagram of the internal change processor graph.
- **projectlead**: Outputs all active projects lead by a specific contact.
- **projects**: outputs all active projects
- **statistics**: Generates statistics on the vault in YAML format.
- **table**: Generates a sorted table of pages, with optional front matter fields in additional columns.
- **timeline**: Generates a timeline for the selected document, with entries extracted from the journal, newest entry first
- **toc**: Outputs a table of contents for the current document.
- **weekly**: Generates a weekly overview of activities, extracted from the journal
- **weeknav**: Generates calendar navigation in the weekly journal

### Output formats

- **json**: `application/json`, fenced
- **markdown**: `text/markdown`, inline
<!--/query (7a6622e1)-->

Legend:

- 🟢: the extension is enabled and configured correctly. All good!
- 🔴: the extension is enabled but not configured correctly. Check the errors and fix them in the front matter of this file!
- ⚪️: the extension is not enabled and not doing anything.

If you have OmniFocus installed, then you can also enable the `omnifocus` extension to have the project priorities and OmniFocus URLs resolved from there. Make sure to set up a folder in OmniFocus that holds your demo projects, and then configure that name for the extension here.
