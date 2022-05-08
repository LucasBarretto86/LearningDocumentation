## Start new application
~~~
rails new my-home-app --database=postgresql
~~~

## Install postgres
~~~
sudo apt-get install libpq-dev
~~~

### Add to gem file
~~~
gem 'pg', '~> 1.2', '>= 1.2.3'
~~~

### Config postgres
~~~
sudo -u postgres -i

psql
~~~


## installing ActiveStorage
~~~
rails active_storage:install

rails db:migrate
~~~

### Enabling image variants - Add gem
~~~
gem 'image_processing', '~> 1.2'
~~~

## Adding Stimulus
~~~
yarn add stimulus
~~~

## Config stimimuls on packs/application.js
~~~
import { Application } from 'stimulus'
import { definitionsFromContext } from 'stimulus/webpack-helpers'

const application = Application.start()

const controllers = require.context('controllers/fudgeballs', true, /_controller\.js$/)
application.load(definitionsFromContext(controllers))
~~~


## Image Lazy Load - Pack config
### JS packs import
~~~
import ImageLazyLoading from '../lib/image_lazy_loading'

ImageLazyLoading.start()
~~~


### Stimlus controller for lazy load

~~~
require('intersection-observer')
import Lozad from 'lozad'

const ImageLazyLoading = {
  start () {
    document.addEventListener('turbolinks:load', () => {
      const observer = Lozad()
      observer.observe()
    })

    document.addEventListener('ajax:done', () => {
      const observer = Lozad()
      observer.observe()
    })
  }
}

export default ImageLazyLoading
~~~


### Create role for notebook user
~~~
create role [OS user] with createdb login password ['123456'];   
~~~

### Adding Bootstrap
~~~
yarn add bootstrap jquery popper.js
~~~

### Config

#### add to the enviroment.js
~~~
const webpack = require('webpack')

environment.plugins.append("Provide", new webpack.ProvidePlugin({
    $: 'jquery',
    jQuery: 'jquery',
    Popper: ['popper.js', 'default']
}))	
~~~

#### add to the javascript/packs/application.js
~~~
import "bootstrap"
import "../stylesheets/application.scss"

document.addEventListener("turbolinks:load", () => {
    $('[data-toggle="tooltip"]').tooltip()
    $('[data-toggle="popover"]').popover()
})
~~~

#### create a app/stylesheets/application.scss
~~~
	@import "~bootstrap/scss/bootstrap";
~~~
		


# Image Lazy Load - Pack config
### JS packs import
~~~
import ImageLazyLoading from '../lib/image_lazy_loading'

ImageLazyLoading.start()
~~~


### Stimlus controller for lazy load

~~~
require('intersection-observer')
import Lozad from 'lozad'

const ImageLazyLoading = {
  start () {
    document.addEventListener('turbolinks:load', () => {
      const observer = Lozad()
      observer.observe()
    })

    document.addEventListener('ajax:done', () => {
      const observer = Lozad()
      observer.observe()
    })
  }
}

export default ImageLazyLoading
~~~

  scope :premiums, -> { enabled.where("price > 0") }

    has_many :sections, class_name: "WebsiteTemplateSection"


## Searchable Concern
~~~
module WebsiteTemplate::Searchable
  extend ActiveSupport::Concern

  included do
    def self.search(value, tag_scope = nil)
      return nil if value.blank?
      results = search_tags(value, tag_scope) + search_templates(value, tag_scope)
      results.uniq
    end

    private
      def self.search_tags(value, tag_scope = nil)
        tags = Rails.cache.fetch("website_templates/search/tags", expires_in: 24.hours) { WebsiteTemplate.joins(:tags).pluck("tags.identifier").uniq.map { |i| [i, i.tr("-", " ")] } }
        needles = search_haystack(tags, value, stop_words: [/convite/], threshold: 0.7)

        return [] if needles.blank?
        results = WebsiteTemplate.enabled.joins(:tags).where("tags.identifier in (?)", needles)
        results = results.tagged_as(tag_scope) if tag_scope.present?
        results
      end

      def self.search_templates(value, tag_scope = nil)
        templates = Rails.cache.fetch("website_templates/search/identifiers", expires_in: 24.hours) { WebsiteTemplate.pluck(:identifier).map { |i| [i, i.tr("-", " ")] } }
        needles = search_haystack(templates, value, stop_words: [/aniversario/, /cha-de-bebe/, /cha-de-fraldas/], threshold: 0.7)

        return [] if needles.blank?
        results = WebsiteTemplate.enabled.where(identifier: needles)
        results = results.tagged_as(tag_scope) if tag_scope.present?
        results
      end

      def self.search_haystack(haystack, value, stop_words: nil, threshold: nil)
        fuzzy = FuzzyMatch.new(haystack, read: :second, stop_words: stop_words).find_all(value, threshold: threshold)
        partial = haystack.select { |hay| hay.second.include?(value) }

        (fuzzy | partial).map(&:first)
      end
  end
end

~~~

###

~~~
  before_action :set_variant

  private

  def set_variant
    request.variant = :desktop unless request.user_agent =~ /Mobile|webOS/
  end
end
~~~


### Stimulus Config
~~~
/ Load all the controllers within this directory and all subdirectories.
// Controller files must be named *_controller.js.

import { Application } from 'stimulus'
import { definitionsFromContext } from 'stimulus/webpack-helpers'

const application = Application.start()

const controllers = require.context('controllers/fudgeballs', true, /_controller\.js$/)
application.load(definitionsFromContext(controllers))
~~~



Class: 


# frozen_string_literal: true

class Property < ApplicationRecord
  has_many_attached :photos

  validates :name, presence: true

  def cover
    return nil unless photos.attached?

    photo = photos.third || photos.first

    photo.variant(resize: "256x256").processed
  end
end


Controller

# frozen_string_literal: true
class PropertiesController < ApplicationController
  before_action :set_property, only: %i[show edit]

  def index
    @properties = Property.all
  end

  def new
    @property = Property.new
  end

  def show; end

  def create
    @property = Property.create(property_params)

    redirect_to property_path(@property) if @property.valid?

    flash[:error] = @property.errors.full_messages.to_sentence
    render :new
  end

  private

  def set_property
    @property = Property.find(params[:id])
  end

  def property_params
    params.require(:property).permit(:name, photos: [])
  end
end



Seeds: 

# frozen_string_literal: true

# This file should contain all the record creation needed to seed the database with its default values.
# The data can then be loaded with the bin/rails db:seed command (or created alongside the database with db:setup).
#
# Examples:
#
#   movies = Movie.create([{ name: 'Star Wars' }, { name: 'Lord of the Rings' }])
#   Character.create(name: 'Luke', movie: movies.first)
path = Rails.root.join('tmp/images')

['628 72nd St', '315 Prestons Mill Rd', '5310 Ashmere Ln', '29830 SW Montebello Dr', '20411 Clay Pigeon Ct', '288 W 17th St',
 '145 Edgewood Ave #1', 'Po Box 457', '11 Syndicate St', '80 Shoemaker St', '521 Washington St #296', '272 Ward Ave #APT 23K',
 '17371 SE 67th St', '3904 Donnell Dr', '13247 Anchor Point Ln', '7805 Ga 251 Hwy', '234 Ben Dewitt Rd', '718 Boundary Blvd',
 '1341 Tub Run Hollow Rd', '2941 W Park Ave', '4987 Porter Pond Rd', '5287 Mcghees Mill Rd', '209 George St', '31 Phoenix Ct',
 '429 S 15th St', '208 Gravy Ln', '1350 Fulton Ave', '40101 184th Hwy', '7920 Clearview Dr', '527 E Park St', '602 Broadway St',
 '4934 Weatherstone Ln SE', 'Julia', '401 N Wyandotte Ave', '2919 Monroe St', '1045 S 800th E', '30075 E Meissner Rd',
 '922 Upper Valley Dr', '24548 Al 251 Hwy', '905 Logan St', '754 Apollo Ct', '11006 Bridge House Rd', '116 Clearbrook Dr',
 '717 Red Oak St', '409 Randolph St', '878 Placid Lake Dr', '196 Twin Mountain Lake Cir', '1149 44th St', '2041 Schuller Way',
 '9153 Jerry Dr'].each do |name|
  property = Property.new(name: name)

  Dir.open(path).each do |file|
    next if %w[. ..].include?(file)

    property.photos.attach(io: File.open([path, file].join('/')), filename: file)
    property.save!
  end

end

