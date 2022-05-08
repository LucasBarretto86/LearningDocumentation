class CreateCoins < ActiveRecord::Migration[5.2]
  def change
    create_table :coins do |t|
      t.string :name, null: false, index: {unique: true}
      t.string :acronym, null: false, index: {unique: true}
      t.string :url_image

      t.timestamps
    end
  end
end
