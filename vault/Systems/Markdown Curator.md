---
banner: "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fready.com.vn%2Fwp-content%2Fuploads%2F2021%2F05%2Fmarkdown.jpg&f=1&nofb=1&ipt=8891bd283594aa20ebea7a22ee0f94ebb1a0be6d9fcfb53c68c77d5edb596b26&ipo=images"
---
The Markdown Curator is a "Java 21+ library/application framework for monitoring repositories of Markdown documents, running queries on them, and inserting the output back into the documents."

The simplest explanation:

- You write queries directly in your (Markdown) content.
- Queries are defined in YAML-embedded-in-HTML-comments. That makes the query definitions disappear when the Markdown is previewed or exported.
- The Markdown Curator detects changes to the content, runs all queries, and updates the query output accordingly.

Here's a an example: a query that outputs a sorted list of all notes in the folder of this note, **Systems**:

<!--query:list-->
- [[Logseq]]
- [[Markdown Curator Demo]]
- [[Markdown Curator]]
- [[Obsidian]]
<!--/query (eec7190f)-->

The result is what I call "dynamic content in static Markdown documents, without lock-in". What I mean by that:

- **dynamic**: because the Markdown Curator runs in the background, monitors files and updates them automatically. It does that so fast that it seems instant.
- **static**: the output of queries is embedded in the Markdown files themselves, like all other content. 
- **without lock-in**: the queries and their output are plaintext, and do not depend on a special editor and/or plug-in. In case you decide to stop using the Markdown Curator, you only need to remove the query tags from the content.

The [[Markdown Curator Demo]] - that includes this file - shows some of what the tool can do.

See [voostindie/markdown-curator](https://github.com/voostindie/markdown-curator) for more information.
