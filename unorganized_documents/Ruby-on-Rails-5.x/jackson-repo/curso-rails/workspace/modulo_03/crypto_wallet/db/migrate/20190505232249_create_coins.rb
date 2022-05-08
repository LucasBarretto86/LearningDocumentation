class CreateCoins < ActiveRecord::Migration[5.2]
  def change
    create_table :coins do |t|
      #Por convesão o Rails automaticamente cria um campo id auto increment, então não precisa ser criado.
      t.string :description
      t.string :acronym
      t.string :string
      t.string :url_image

      #Também por padrão o rails cria colunas para registrar a data e hora da criação e da ultima modificação de cada registro;~
      t.timestamps
    end
  end
end
