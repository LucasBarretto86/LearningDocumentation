namespace :dev do
  desc "Initialize enviroment reloading database using seeds file"

  task init: :environment do
    if Rails.env.development?
      tasks = %w[db:drop db:create db:migrate db:seed]

      tasks.each do |task|
        spinner = TTY::Spinner.new("[#{task}] :spinner ", format: :dots)
        spinner.auto_spin
        %x(rails #{task})
        spinner.success()
      end
    end
  end
end
