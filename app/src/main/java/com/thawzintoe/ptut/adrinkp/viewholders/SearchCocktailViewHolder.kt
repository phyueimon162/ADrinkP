package com.thawzintoe.ptut.adrinkp.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.thawzintoe.ptut.adrinkp.R
import com.thawzintoe.ptut.adrinkp.deligate.onTapCocktailDetail
import com.thawzintoe.ptut.adrinkp.utils.load
import com.thawzintoe.ptut.adrinkp.viewholders.base.BaseViewHolder
import com.thawzintoe.ptut.adrinkp.vos.searchList.SearchDrinksItem
import kotlinx.android.synthetic.main.content_search_item.view.*

class SearchCocktailViewHolder(itemView:View,private val tapCocktailDetail:onTapCocktailDetail):
        BaseViewHolder<SearchDrinksItem>(itemView) {
    private lateinit var searchDrinksItem: SearchDrinksItem
    private val strImage=itemView.strThumb
    private val strName=itemView.strName
    private val strDesc=itemView.strDesc
    private val strCategory=itemView.strCategory

    override fun setData(data: SearchDrinksItem) {
        searchDrinksItem=data
        if(data!=null){
            strImage.load(data.strDrinkThumb!!)
            strName.text=data.strDrink
            strDesc.text=data.strInstructions
            strCategory.text=data.strCategory
        }else{
            itemView.visibility=View.GONE
        }
    }

    override fun onClick(v: View?) {
        tapCocktailDetail.lunchCocktailDetail(searchDrinksItem,itemView.strThumb)
    }
}