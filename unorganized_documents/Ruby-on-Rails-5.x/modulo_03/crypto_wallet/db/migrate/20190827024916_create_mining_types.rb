class CreateMiningTypes < ActiveRecord::Migration[5.2]
  def change
    create_table :mining_types do |t|
      t.string :name, null: false, index: {unique: true}
      t.string :acronym, null: false, index: {unique: true}
      t.timestamps
    end
  end
    add_reference :coins, :mining_types, index: true, foreign_key: true

end
