module ApplicationHelper
  def app_name
    "Kit3s's CRYPTO WALLET"
  end

  def br_date(date)
    date.strftime("%d/%m/%Y")
  end

  def current_enviroment
    if Rails.env.production?
      "Production"
    elsif Rails.env.development?
      "Development"
    elsif Rails.env.test?
      "Test"
    end
  end

end
