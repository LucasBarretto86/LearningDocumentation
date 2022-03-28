# Learning CSS

- [Learning CSS](#learning-css)
  - [Snippets](#snippets)
    - [SVG Dropdown shadow](#svg-dropdown-shadow)
    - [Hiding scroll](#hiding-scroll)
    - [Hiding input spinner](#hiding-input-spinner)
    - [Highlight every element from view](#highlight-every-element-from-view)

## Snippets

### SVG Dropdown shadow

```css
svg {
  filter: drop-shadow(0 0 4px #ff0090);
}

```

### Hiding scroll

```css
.scroll { /* Edge */
    -ms-overflow-style: none;
}
    
.scroll::-webkit-scrollbar { /* Chrome, Safari, Opera, Firefox */
    display: none; 
}
```

### Hiding input spinner

```css
.spinner { /* Firefox */
    
    -moz-appearance:textfield;
 }
    
.spinner::-webkit-outer-spin-button,
.spinner::-webkit-inner-spin-button { /* Chrome, Safari, Edge, Opera */
    -webkit-appearance: none;
    margin: 0;
}
```

### Highlight every element from view

```css
* { background-color: rgba(255,0,0,.2); }
* * { background-color: rgba(0,255,0,.2); }
* * * { background-color: rgba(0,0,255,.2); }
* * * * { background-color: rgba(255,0,255,.2); }
* * * * * { background-color: rgba(0,255,255,.2); }
* * * * * * { background-color: rgba(255,255,0,.2); }
* * * * * * * { background-color: rgba(255,0,0,.2); }
* * * * * * * * { background-color: rgba(0,255,0,.2); }
* * * * * * * * * { background-color: rgba(0,0,255,.2); }
```
