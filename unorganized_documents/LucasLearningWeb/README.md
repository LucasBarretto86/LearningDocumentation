#   Lucas Learning WEB documentation

##  HTML

##  CSS
>### Pseudo-Classes
>#### :focus-within  
> Allow you to attack the parent from the element in focus 

>#### :root  
> Allow  various default configurations, but mostly css variables creation
> to create a variable, you set a '--variable-name: value;'
> ##**Example:**
    :root {
        --hero-gradient: linear-gradient(-45deg, #9F02CC, #5484f4);
    }

>### Units REM and EM
> REM and EM has one single difference. 
> #### EM
>  Is a unite based on it's parent's font-size, which means it carries on this size, by consequence that makes easy to gets confused.
> Everytime you see EM unity in one element it's same like says that it uses the current parent font-size and increase it relatively, as default 1em = 16px about, however if parent element has it's font-size changed to font-size: 32px, it's first level children will will have 1em = 32px.

> #### REM
> Simple doesn't inherit the font-size from it's parent, it only inherit from root html.

## SCSS/SASS specifics
>#### Partials
> In scss/sass elements named with underscore can be imported as partials
> 
> _card.scss
> @import "./card.scss"

##  Javascript