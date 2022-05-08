class CoinsController < ApplicationController
  before_action :set_coin, only: [:show, :edit, :update, :destroy]

  def index
    @coins = Coin.all
  end

  def show
  end

  def new
    @coin = Coin.new
  end

  def edit
  end

  def create
    @coin = Coin.create(coin_params)
  end

  def update
    @coin.update coin_params
  end

  def destroy
    @coin.destroy
    respond_to do |format|
      format.html { redirect_to coins_url, notice: 'Coin Successfully Destroyed.' }
    end
  end

  private

  def set_coin
    @coin = Coin.find(params[:id])
  end

  def coin_params
    params.require(:coin).permit(:name, :acronym, :url_image, :mining_type_id)
  end
end
