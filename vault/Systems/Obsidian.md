---
banner: "https://obsidian.md/images/banner.png"
---
[Obsidian](https://obsidian.md) is "a powerful and extensible knowledge base that works on top of your local folder of plain text files."

I've been using Obsidian since late 2020, and after 2+ years I say "amen" to the tagline. It works great for me! This is coming from someone who  strongly dislikes Electron-based applications in general. I have not yet found a suitable macOS-native, except maybe for [iA Writer](https://ia.net/writer). I like that app a lot and use it regularly, but in the end Obsidian is faster for me, thanks to its keyboard shortcuts and a couple of powerful plugins.

I don't use [[Obsidian]] by itself. I combine it with my own [[Markdown Curator]] tool.

## Recommended plugins

[[Obsidian]] has hundreds of plugins. Some people seem to install them all. Not me. I try to keep it to a minimum:

- **Another Quick Switcher**: enhanced Quick Switcher.
- **Banners**: adds Notion-like banners at the top of your notes.
- **Calendar**: adds a calendar view, ideal for browsing daily notes.
- **macOS Keyboard Navigation**: enables macOS-specific keys.
- **Outliner**: work with lists like in Workflowy or RoamResearch.
- **Periodic Notes**: create/manage and your daily, weekly and monthly notes.
- **Vimrc Support**: auto-loads a startup file with Vim commands.

Okay, I cheated. I use a few more. See the next section.

## Recommended theme, fonts and related plugins

The default [[Obsidian]] theme is okay, but not great, in my opinion. Instead I use the **Minimal** theme. 

As the text font I use **Proxima Nova**. and for monospace I use **JetBrains Mono**.

To further customize [[Obsidian]]'s look & feel I use 3 plugins:

- **Minimal Theme Settings**: controls the colors and fonts of the Minimal theme.
	- I use the **Things** color schemes. 
	- I disable the underlining of internal links.
	- I set **iA Writer Quattro V** as the editing font. (I use "Source mode" as the default editing mode.)
- **Style Settings**: offers controls for adjusting theme, plugin and snippet CSS variables.
	- Here I change the font sizes of headings: level 1 to 130%, level 2 to 120% and level 3 to 110%.
- **Hider**: hide UI elements such as tooltips, statusbar, title and more.
	- I hide as much as possible to get a clean UI. This includes things like the app ribbon, the tab title bar, the status bar, tooltips and instructions.

Here's what that looks like (in *reading view* mode):

![[Obsidian with Minimal Theme.png]]

## Recommended snippets

One last customization I have added to my [[Obsidian]] setup is a single CSS snippet:

```css
.cm-comment {
	font-size: 75%;
}
```

This decreases the size of the HTML comment tags. I use these tags only for the custom `<!--query-->` tags of the [[Markdown Curator]].