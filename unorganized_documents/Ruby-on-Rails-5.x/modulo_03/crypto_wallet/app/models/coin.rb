class Coin < ApplicationRecord

  belongs_to :mining_type

  validates :name, null: false, uniqueness: true
  validates :acronym, null: false, uniqueness: true
end
