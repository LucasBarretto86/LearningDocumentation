# Learning Documentation

- [Learning Documentation](#learning-documentation)
  - [SSH](#ssh)
    - [Create SSH](#create-ssh)
    - [Validate SSH](#validate-ssh)
    - [Check SSH public key](#check-ssh-public-key)
  - [ASDF](#asdf)
    - [ASDF Install](#asdf-install)
    - [ASDF Plugins](#asdf-plugins)
      - [Adding plugin dependencies](#adding-plugin-dependencies)
      - [Listing ASDF Plugins](#listing-asdf-plugins)
      - [Adding ASDF Plugins](#adding-asdf-plugins)
    - [Installing through ASDF Plugins](#installing-through-asdf-plugins)
    - [Updating through ASDF Plugins](#updating-through-asdf-plugins)
    - [Set version with ASDF Plugins](#set-version-with-asdf-plugins)
  - [Tableplus](#tableplus)
    - [Tableplus Linux installation](#tableplus-linux-installation)
  - [Git and Github](#git-and-github)
    - [Submodules](#submodules)
      - [Adding submodule](#adding-submodule)
  - [Pull for all submodules for the first time](#pull-for-all-submodules-for-the-first-time)
    - [Updating existing submodules](#updating-existing-submodules)
    - [Pull each submodule](#pull-each-submodule)
      - [Submodule issues](#submodule-issues)
      - [Adding subtree](#adding-subtree)
      - [Updating subtree](#updating-subtree)
        - [Pulling changes](#pulling-changes)
        - [Pushing changes](#pushing-changes)
    - [Tags](#tags)
      - [Listing tags](#listing-tags)
      - [Creating tags](#creating-tags)
      - [Search tags](#search-tags)
    - [Git lfs / Large files on Github](#git-lfs--large-files-on-github)
      - [Extension installation](#extension-installation)
        - [First download the git-lfs file](#first-download-the-git-lfs-file)
        - [Download additional script](#download-additional-script)
      - [Git lfs usage](#git-lfs-usage)
        - [Tracking files](#tracking-files)
    - [Git commands table](#git-commands-table)
  - [Heroku](#heroku)
    - [Staging Deployment](#staging-deployment)
  - [Languages Learning](#languages-learning)
  - [Handling Images](#handling-images)
    - [Installing ImageMagick](#installing-imagemagick)
      - [SVG TO PNG](#svg-to-png)
      - [PSD TO PNG](#psd-to-png)
    - [Installing Potrace](#installing-potrace)
      - [BMP to SVG](#bmp-to-svg)
  - [CURL](#curl)
  - [YARN](#yarn)
    - [Add new dependency](#add-new-dependency)
      - [add only in dev](#add-only-in-dev)
    - [Reinstall all dependencies](#reinstall-all-dependencies)
    - [Adding multiple dependencies version](#adding-multiple-dependencies-version)
    - [Downloading files](#downloading-files)
  - [ESLint](#eslint)
    - [Adding ESlint to the project](#adding-eslint-to-the-project)
    - [Interactive configuration](#interactive-configuration)
    - [ESlint basic config](#eslint-basic-config)
    - [Some additional rules](#some-additional-rules)
      - [To add new rules](#to-add-new-rules)
  - [Concepts](#concepts)
  - [Product Manager vs Product Owner](#product-manager-vs-product-owner)
    - [User Story Framework](#user-story-framework)
      - [Workflow](#workflow)
        - [Theme](#theme)
        - [Initiative](#initiative)
        - [Epic](#epic)
        - [Story](#story)
        - [Task, Subtask, Chores](#task-subtask-chores)
        - [Bug](#bug)
    - [Serialization](#serialization)
    - [Versioning](#versioning)
      - [Build versioning](#build-versioning)
      - [Calendar versioning](#calendar-versioning)
      - [Semantic versioning](#semantic-versioning)
        - [Milestone version](#milestone-version)
    - [What is a Slug?](#what-is-a-slug)
    - [Absolute and Relative paths](#absolute-and-relative-paths)
  - [References](#references)
  - [Gists](#gists)

## SSH

### Create SSH

```shell
ssh-keygen -t rsa -b 4096 -C "joe@example.com"
```

### Validate SSH

```shell
eval "$(ssh-agent -s)"
```

### Check SSH public key

```shell
cat ~/.ssh/id_rsa.pub
```

## ASDF

### ASDF Install

```shell
git clone https://github.com/asdf-vm/asdf.git ~/.asdf --branch v0.4.0
echo -e '\n. $HOME/.asdf/asdf.sh' >> ~/.bashrc
echo -e '\n. $HOME/.asdf/completions/asdf.bash' >> ~/.bashrc
```

### ASDF Plugins

#### Adding plugin dependencies

Each plugin has dependencies so we need to check the plugin repo where they should be listed. For asdf-nodejs they are:

```shell
apt-get install dirmngr gpg curl gawk
```

#### Listing ASDF Plugins

```shell
asdf list-all ruby
```

#### Adding ASDF Plugins

```shell
asdf plugin add nodejs https://github.com/asdf-vm/asdf-nodejs.git
asdf plugin-add python https://github.com/tuvistavie/asdf-python.git
asdf plugin-add ruby https://github.com/asdf-vm/asdf-ruby.git
asdf plugin-add lua https://github.com/Stratus3D/asdf-lua.git
```

### Installing through ASDF Plugins

```shell
asdf  install ruby 3.1.0
```

### Updating through ASDF Plugins

```shell
asdf plugin-update --all
```

### Set version with ASDF Plugins

Global

```shell
asdf global nodejs 16.5.0
```

Local

```shell
asdf local nodejs 12.23.0
```

## Tableplus

### Tableplus Linux installation

```shell
wget -qO - http://deb.tableplus.com/apt.tableplus.com.gpg.key | sudo apt-key add -
sudo add-apt-repository "deb [arch=amd64] https://deb.tableplus.com/debian/20 tableplus main"
sudo apt update
sudo apt install tableplus
```

## Git and Github

### Submodules

Git also allow you to link dependencies as submodules does you can manage  your repos with a project structure

To add a submodule first you need to have a remote repo to be attached as submodule

#### Adding submodule

**Through https - OLD:**

```shell
git submodule add https://github.com/LucasBarretto86/LearningLOVE.git
```

**Through SSH:**

```shell
git submodule add git@github.com:LucasBarretto86/LearningLOVE.git
```

As added a submodule you can control it's versions within the specific module directory

```shell
cd LearningLove

touch test.txt
git add test.txt
git commit -m"Committing directly with a submodule"
git push
```

## Pull for all submodules for the first time

```shell
git submodule update --init --recursive
```

### Updating existing submodules

```shell
git pull --recurse-submodule
```

### Pull each submodule

```shell
git submodule foreach git pull origin main
```

#### Submodule issues

Sometimes a repo that has submodules does not fully updates so here there's few lines you may use

- Remove `.git` caches Re-adding modules and Re-downloading

Within the modules root folder

```shell
# Cleaning submodules and repo indexes
rm -Rf .git/modules/*
rm .git/index

# Adding modules again, before doing this you can check submodules path within the file .gitmodules
cd *SUBMODULES_FOLDER*
git submodule add git@github.com:*USER_NAME*/*REPO_NAME*.git

# Pull from each submodule
cd ..
git submodule foreach git pull origin main
```

#### Adding subtree

Subtree is very similar to submodules, however subtree allow you to bring in external repos by merging it and squashing

```shell
git subtree add --prefix {local directory being pulled into} {remote repo URL} {remote branch} --squash
```

#### Updating subtree

To update subtrees you have to use pull and push referring the prefix and the remote repos path

##### Pulling changes

```shell
git subtree pull --prefix {local directory being pulled into} {remote repo URL} {remote branch} --squash
```

##### Pushing changes

```shell
git subtree push --prefix {local directory being pulled into} {remote repo URL} {remote branch}
```

### Tags

#### Listing tags

```shell
git tag
```

#### Creating tags

```shell
git tag -a v2.3.4 -m "[2.3.4] - 2022-04-25"
```

#### Search tags

### Git lfs / Large files on Github

Git has an extension to control larger files

#### Extension installation

First is required to download files

##### First download the git-lfs file

<https://github.com/git-lfs/git-lfs/releases>

##### Download additional script

```shell
curl -s https://packagecloud.io/install/repositories/github/git-lfs/script.deb.sh | sudo  bash
```

#### Git lfs usage

```shell
git lfs install
```

##### Tracking files

Within the repo with large files start tracking files

```shell
git lfs track "*.capx"
```

### Git commands table

| Command|Description |
| :--- |:---- |
|`git rm -r --cached .`| Clear git cache for all files |
|`git branch | grep -v "main" | xargs git branch -D`| Clean git branches |
|`git branch -M NEW_NAME`| Renaming branch and origin
|`git branch -m NEW_NAME`| Renaming branch locally |
|`git reset --soft HEAD~1`| Retrieve one commit `~1`  and return it to stage |
|`git reset --hard`| Undo every change not committed, also allow you to undo commits with flag `HEAD~1` |
|`git push --force`| Force push in case it diverge from origin - Careful, no rollback |
|`git push --set-upstream origin BRANCH_NAME`| Push and set upstream |
|`git fetch --prune`| Updates existing branches|
|`git branch -vv`| Branch status|
|`git config --global user.name USER_NAME`| Set global user name|
|`git config --global user.email USER_EMAIL`| Set global user email|
|`git config --global user.password PASSWORD`| Set global user password|
|`git revert -m 1 COMMIT_SHA`| Revert changes from a commit|
|`git rebase BRANCH`| Sync local branch with another specific branch, conflicts may happen and `git push --force` might be need !Careful!|
|`git remote add origin git@github.com:USER_NAME/REPO_NAME.git`| Add repo as remote|
|`git submodule add origin git@github.com:USER_NAME/REPO_NAME.git`| Add repo as submodule|
|`git submodule update`| To make pull in every submodule |
|`git submodule update MODULE_PATH`| To make pull in specific submodule |
|`git subtree add --prefix PATH_NAME REMOTE_REPO_URL BRANCH_NAME --squash`| To add a subtree to the project |
|`git subtree pull --prefix PATH_NAME REMOTE_REPO_URL BRANCH_NAME --squash`| To pull changes from original repo |
|`git subtree push --prefix PATH_NAME REMOTE_REPO_URL BRANCH_NAME --squash`| To push changes to a specific repo |

## Heroku

### Staging Deployment

## Languages Learning

- [Learning Assembly](https://github.com/LucasBarretto86/LearningAssembly)
- [Learning C++](https://github.com/LucasBarretto86/LearningCPP)
- [Learning CSS](https://github.com/LucasBarretto86/LearningCSS)
- [Learning SCSS](https://github.com/LucasBarretto86/LearningCSS/LearningSCSS)
- [Learning JS]([specifics/js.md](https://github.com/LucasBarretto86/LearningJS))
- [Learning LOVE](https://github.com/LucasBarretto86/LearningLOVE)
- [Learning Lua](https://github.com/LucasBarretto86/LearningLua)
- [Learning Markdown](https://github.com/LucasBarretto86/LearningMarkdown)
- [Learning Postgres](https://github.com/LucasBarretto86/LearningSQL/src/Postgres/README.md)
- [Learning Python](https://github.com/LucasBarretto86/LearningPython)
- [Learning ReactJS](https://github.com/LucasBarretto86/LearningReactJS)|
- [Learning Ruby on Rails](https://github.com/LucasBarretto86/LearningRubyOnRails)
- [Learning SQL](https://github.com/LucasBarretto86/LearningSQL)

## Handling Images

### Installing ImageMagick

```shell
sudo apt install Imagemagick
```

#### SVG TO PNG

```shell
convert -background -quality 100 *.svg -set filename:base "%[basename]" "%[filename:base].png"
```

#### PSD TO PNG

```shell
convert  *.psd -set filename:base "%[basename]" -quality 100 "%[filename:base].png"
convert cover.ai cover.png
```

### Installing Potrace

Potrace(TM) is a tool for tracing a bitmap, which means, transforming a bitmap into a smooth, scalable image. It only traces black and white input images

```shell
sudo apt install potrace
```

#### BMP to SVG

```shell
potrace example.bmp -s -o example.svg
```

![original BMP](assets/images/example.bmp)
![Converted](assets/images/example.svg)

## CURL

## YARN

### Add new dependency

```shell
yarn add dependency_name
```

#### add only in dev

```shell
yarn add dependency_name -D
```

### Reinstall all dependencies

```shell
yarn install --check-files
```

### Adding multiple dependencies version

new dependency syntax -> "`dependency-alias`": "npm:`dependency-name@version`"
older dependency syntax -> "`dependency-name`": "`version`"

```json
// package.json
{
  "dependencies": {
    "@analytics": "npm:analytics@^0.6.2",
    "@analytics/google-analytics": "^0.5.2",
    "@apollo/client/updated": "npm:apollo/client@^3.6.2",
    "@apollo/client": "3.5.8"
  }
}

```

### Downloading files

```shell
curl https://emoji.slack-edge.com/T58JKBZJS/merged/adb3ef9def323d9a.png --output  ~/Downloads/images/merged.png
```

## ESLint

### Adding ESlint to the project

```shell
yarn add -D eslint
```

### Interactive configuration

```shell
eslint --init

# Output
# $ eslint --init
# You can also run this command directly using 'npm init @eslint/config'.
# npx: installed 40 in 8.683s
# ✔ How would you like to use ESLint? · problems
# ✔ What type of modules does your project use? · esm
# ✔ Which framework does your project use? · react
# ✔ Does your project use TypeScript? · No / Yes
# ✔ Where does your code run? · browser
# ✔ What format do you want your config file to be in? · JavaScript
# The config that you've selected requires the following dependencies:

# eslint-plugin-react@latest
# ✔ Would you like to install them now? · No / Yes
# ✔ Which package manager do you want to use? · yarn
```

### ESlint basic config

```js
// .eslintrc.js

module.exports = {
  'env': {
    'browser': true,
    'es2021': true
  },
  'extends': [
    'eslint:recommended',
    'plugin:react/recommended'
  ],
  'parserOptions': {
    'ecmaFeatures': {
      'jsx': true
    },
    'ecmaVersion': 'latest',
    'sourceType': 'module'
  },
  'plugins': [
    'react'
  ],
  'rules': {
    'array-bracket-spacing': ['error', 'never'],
    'brace-style': ['error', '1tbs'],
    'comma-dangle': ['error', {
      'arrays': 'never',
      'objects': 'never',
      'imports': 'never',
      'exports': 'never',
      'functions': 'ignore'
    }],
    'jsx-quotes': ['error', 'prefer-single'],
    'keyword-spacing': ['error'],
    'linebreak-style': ['error', 'unix'],
    'no-console': 'warn',
    'object-curly-spacing': ['error', 'always'],
    'quotes': ['error', 'single', { 'avoidEscape': true }],
    'quote-props': ['error', 'consistent'],
    'react/prop-types': ['off'],
    'semi': ['error', 'never'],
    'space-in-parens': ['error', 'never']
  }
}

```

### Some additional rules

```js
  'rules': {
    'array-bracket-spacing': ['error', 'never'],
    'brace-style': ['error', '1tbs'],
    'comma-dangle': ['error', {
      'arrays': 'never',
      'objects': 'never',
      'imports': 'never',
      'exports': 'never',
      'functions': 'ignore'
    }],
    'jsx-quotes': ['error', 'prefer-single'],
    'keyword-spacing': ['error'],
    'linebreak-style': ['error', 'unix'],
    'no-console': 'warn',
    'object-curly-spacing': ['error', 'always'],
    'quotes': ['error', 'single', { 'avoidEscape': true }],
    'quote-props': ['error', 'consistent'],
    'react/prop-types': ['off'],
    'semi': ['error', 'never'],
    'space-in-parens': ['error', 'never']
  }

```

#### To add new rules

<https://eslint.org/docs/rules/>

## Concepts

## Product Manager vs Product Owner

![PM and PO Comparison](assets/images/po-and-pm.png)

### User Story Framework

![Agile Management](assets/images/epics-vs-stories-agile-development.png)

In agile management the breakdown

#### Workflow

![Agile Work Flow](assets/images/AgileWorkflow.svg)

- [Theme](#theme)
- [Initiative](#initiative)
- [Epic](#epic)
- [Story](#story)
- [Task, Subtask, Chores](#task-subtask-chores)
- [Bug](#bug)

##### Theme

##### Initiative

##### Epic

##### Story

##### Task, Subtask, Chores

##### Bug

### Serialization

Basically serialize is the process to convert data to a byte stream that will represent an object to another end

[What is serialization](https://www.freecodecamp.org/news/what-is-serialization/)

### Versioning

Basically it defines how to set unique sequential identification for a software, there is few schemes to do version:

- Build versioning
- Calendar versioning
- Semantic versioning
- Milestone versioning
  
#### Build versioning

Simple V1, V2, V3

#### Calendar versioning

It's basically set version based on current year, month, day. Used mostly to softwares that have consistent yearly or monthly releases, ubuntu is a good example:

![Ubuntu Calendar Versioning](assets/images/ubuntu-versions.png)

Typically the format used is `YY.MM.DD` or `YYYY.MM`

It's also common to add a unique after the date schema to specify a hotfix: `YY.MM.HOTFIX` or `YY.MM.DD.HOTFIX`

```txt
21.04.1
21.04.2
```

#### Semantic versioning

Semantic versioning is perhaps the most used way to make clear versions, the semantic versioning are `MAJOR.MINOR.PATCH`

- PATCH - Means that this version is implementing a hotfix and it's backward compatible
- MINOR - Means we are introducing a new feature, a new functionality that is also backward compatible and if there's any dependency installation or upgrade it won't require any change on the current code base.
- MAJOR - Increment the major version means that the new features or the code changes that are being implemented isn't backward compatible, which means the whole application will be effected

But there's some rules, whenever a MINOR version is implemented the PATCH version becomes `0`, Whenever a MAJOR version is implemented both MINOR and PATCH version becomes `0`

```md
**Patch change**
- 1.0.1
- 1.0.2
- ...
- 1.0.20

**Minor change**
- 1.1.0
- 1.2.0
- ...
- 1.15.0

**Major change**
- 2.0.0
- 3.0.0
- ...
- 10.0.0
```

Semantic version can also use suffixes to describe if a release is in  `pre-alpha`, `alpha`, `beta`, `close-beta` phases, it normally means that this releases are mostly available for testing purposes

```md
1.0.1b
1.0.2-beta
1.0.2-alpha
1.0.2-alpha-1
1.0.2-alpha.2
1.0.2a
```

![releases-life-cycle]("assets/../assets/images/software-dev-cycle.svg)

##### Milestone version

Basically is a version number or a name given at random or decided arbitrarily, mostly for marketing reasons

### What is a Slug?

What is a Slug? A slug is the last part of the url containing a unique string which identifies the resource being served by the web service. In that sense, a slug is a unique identifier for the resource.

### Absolute and Relative paths

An absolute, or full, path begins with a drive letter followed by a colon, such as D:.

A relative path refers to a location that is relative to a current directory. Relative paths make use of two special symbols, a dot (.) and a double-dot (..), which translate into the current directory and the parent directory. Double dots are used for moving up in the hierarchy. A single dot represents the current directory itself.

In the example directory structure below, assume you used Windows Explorer to navigate to `D:\Data\Shapefiles\Soils`. After navigating to this directory, a relative path will use `D:\Data\Shapefiles\Soils` as the current directory (until you navigate to a new directory, at which point the new directory becomes the current directory). The current directory is sometimes referred to as the root directory.

## References

- [S.O.L.I.D](https://www.digitalocean.com/community/conceptual_articles/s-o-l-i-d-the-first-five-principles-of-object-oriented-design)
- [GraphQL vs REST](https://www.imaginarycloud.com/blog/graphql-vs-rest/)
- [Serialization](https://www.freecodecamp.org/news/what-is-serialization/)
- [Web Developer Playbook: Slug](https://medium.com/dailyjs/web-developer-playbook-slug-a6dcbe06c284)
- [Paths explained: Absolute, relative, UNC, and URL](https://desktop.arcgis.com/en/arcmap/10.3/tools/supplement/pathnames-explained-absolute-relative-unc-and-url.htm#GUID-5118AC85-57E4-4027-AC24-FB6E99FADEFF)
- [User Story Framework](https://en.wikipedia.org/wiki/User_story)
- [Why the PM and the PO should be the same person](https://www.delibr.com/post/product-manager-vs-product-owner)

## Gists

[Random Stuff](https://gist.github.com/LucasBarretto86/2cc6e13a894d29b811d66604389edf3c)
