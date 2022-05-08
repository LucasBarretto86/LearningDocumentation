module ErrorsHelper

  def display_error_field(origin, error)
    render partial: "views/application/error", locals: {origin: origin, error: error}
  end

end
