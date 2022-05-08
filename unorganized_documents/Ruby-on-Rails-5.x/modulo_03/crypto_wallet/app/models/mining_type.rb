class MiningType < ApplicationRecord

  has_many :coins

  validates :name, null: false, uniqueness: true
  validates :acronym, null: false, uniqueness: true
end
