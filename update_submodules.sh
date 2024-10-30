#!/bin/bash

# Loop through each submodule
git submodule foreach '
  # Add all changes in the current submodule
  git add .
  # Commit with a generic message if there are staged changes
  if ! git diff --cached --quiet; then
    git commit -m "Update project"
  else
    echo "No changes to commit in $(pwd)"
  fi
  # Push to the remote repository
  git push || echo "Push failed in $(pwd)"
'