class MiningTypesController < ApplicationController
  before_action :set_mining_type, only: [:show, :edit, :create, :update, :destroy]

  def index
    @mining_types = MiningType.all
  end

  def show
  end

  def new
    @mining_type = MiningType.new
  end

  def create
    @mining_type = MiningType.create(mining_type_params)

    respond_to do |format|
      if @mining_type.save
        format.html { redirect_to @mining_type, notice: 'New Mining Type Successfully Created.' }
      else
        format.html { render :new }
      end
    end
  end

  def edit
  end

  def update
    @mining_type.update(mining_type_params)
  end

  def destroy
    @mining_type.destroy
    respond_to do |format|
      format.html { redirect_to :mining_types, notice: 'Mining Type Successfully Destroyed.' }
    end
  end

  private

  def set_mining_type
    @mining_type = MiningType.find(params[:id])
  end

  def mining_type_params
    params.require(:mining_type).permit(:name, :acronym)
  end
end
