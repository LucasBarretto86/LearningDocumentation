Rails.application.routes.draw do
  root to: 'application#index'

  resources :coins
  resources :mining_types
end
