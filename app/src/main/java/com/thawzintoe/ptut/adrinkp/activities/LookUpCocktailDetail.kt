package com.thawzintoe.ptut.adrinkp.activities

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.thawzintoe.ptut.adrinkp.R
import com.thawzintoe.ptut.adrinkp.activities.base.BaseActivity
import com.thawzintoe.ptut.adrinkp.components.EmptyViewPod
import com.thawzintoe.ptut.adrinkp.mvp.presenters.LookUpPresenter
import com.thawzintoe.ptut.adrinkp.mvp.presenters.RandomPresenter
import com.thawzintoe.ptut.adrinkp.mvp.views.LookUpView
import com.thawzintoe.ptut.adrinkp.mvp.views.RandomView
import com.thawzintoe.ptut.adrinkp.utils.*
import com.thawzintoe.ptut.adrinkp.vos.lookUpList.LookUpItem
import com.thawzintoe.ptut.adrinkp.vos.randomList.RandomDrinksItem
import kotlinx.android.synthetic.main.activity_search_detail.*
import kotlinx.android.synthetic.main.content_category_item.*
import kotlinx.android.synthetic.main.content_search_detail.*
import java.text.SimpleDateFormat

class LookUpCocktailDetail:BaseActivity(),LookUpView {
    private lateinit var mLookUpPresenter: LookUpPresenter
    private var emptyViewPod:EmptyViewPod?=null

    companion object {
        fun newIntent(context: Context,id:String): Intent {
            val intent= Intent(context, LookUpCocktailDetail::class.java)
            intent.putExtra(Detail_ID,id)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_detail)
        setSupportActionBar(toolbarDetail)
        toolbarDetail.setNavigationOnClickListener{
            onBackPressed()
        }
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.title = ""
        val id=intent.getStringExtra(Detail_ID)
        shimmerLayout.startShimmerAnimation()
        mLookUpPresenter=ViewModelProviders.of(this).get(LookUpPresenter::class.java)
        mLookUpPresenter.initPresenter(this)
        mLookUpPresenter.onNotifyLookUpDetail(id)
        mLookUpPresenter.errorLD.observe(this,this)
        mLookUpPresenter.lookUpLD!!.observe(this, Observer<List<LookUpItem>>{

            setUpComponent(it!![0])
        })

    }
    private fun setUpComponent(randomDrink:LookUpItem) {
        shimmerLayout.stopShimmerAnimation()
        Glide.with(applicationContext)
                .load(randomDrink.strDrinkThumb)
                .into(strThumb)
        detailCategory.text = randomDrink.strDrink
        detailIBA.text=randomDrink.strCategory
        detailDate.text = prettyTime(randomDrink.dateModified!!)
        detailAlcoholic.text = randomDrink.strAlcoholic
        detailGlass.text = randomDrink.strGlass
//        detailInstruction.setJustificationMode(JUSTIFICATION_MODE_INTER_WORD);
        detailInstruction.text = randomDrink.strInstructions

        chceckIngredient(randomDrink)
        checkMeasure(randomDrink)
    }

    private fun chceckIngredient(searchDrinksItem: LookUpItem) {
        if (!searchDrinksItem.strIngredient1.isNullOrEmpty()) {
            strIngredient1.visibility = View.VISIBLE
            strIngredient1.text = searchDrinksItem.strIngredient1
        } else { strIngredient1.visibility = View.GONE }
        if (!searchDrinksItem.strIngredient2.isNullOrEmpty()) {
            strIngredient2.visibility = View.VISIBLE
            strIngredient2.text = searchDrinksItem.strIngredient2
        } else { strIngredient2.visibility = View.GONE }
        if (!searchDrinksItem.strIngredient3.isNullOrEmpty()) {
            strIngredient3.visibility = View.VISIBLE
            strIngredient3.text = searchDrinksItem.strIngredient3
        } else { strIngredient3.visibility = View.GONE }
        if (!searchDrinksItem.strIngredient4.isNullOrEmpty()) {
            strIngredient4.visibility = View.VISIBLE
            strIngredient4.text = searchDrinksItem.strIngredient4
        } else { strIngredient4.visibility = View.GONE }
        if (!searchDrinksItem.strIngredient5.isNullOrEmpty()) {
            strIngredient5.visibility = View.VISIBLE
            strIngredient5.text = searchDrinksItem.strIngredient5
        } else { strIngredient5.visibility = View.GONE }
        if (!searchDrinksItem.strIngredient6.isNullOrEmpty()) {
            strIngredient6.visibility = View.VISIBLE
            strIngredient6.text = searchDrinksItem.strIngredient6
        } else { strIngredient6.visibility = View.GONE }
        if (!searchDrinksItem.strIngredient7.isNullOrEmpty()) {
            strIngredient7.visibility = View.VISIBLE
            strIngredient7.text = searchDrinksItem.strIngredient7
        } else { strIngredient7.visibility = View.GONE }
        if (!searchDrinksItem.strIngredient8.isNullOrEmpty()) {
            strIngredient8.visibility = View.VISIBLE
            strIngredient8.text = searchDrinksItem.strIngredient8
        } else { strIngredient8.visibility = View.GONE }
        if (!searchDrinksItem.strIngredient9.isNullOrEmpty()) {
            strIngredient9.visibility = View.VISIBLE
            strIngredient9.text = searchDrinksItem.strIngredient9
        } else { strIngredient9.visibility = View.GONE }
    }

    private fun checkMeasure(searchDrinksItem: LookUpItem) {
        if (!searchDrinksItem.strMeasure1.isNullOrEmpty()) {
            strMeasure1.visibility= View.VISIBLE
            strMeasure1.text = searchDrinksItem.strMeasure1
        } else { strMeasure1.visibility = View.GONE }
        if (!searchDrinksItem.strMeasure2.isNullOrEmpty()) {
            strMeasure2.visibility= View.VISIBLE
            strMeasure2.text = searchDrinksItem.strMeasure2
        } else { strMeasure2.visibility = View.GONE }
        if (!searchDrinksItem.strMeasure3.isNullOrEmpty()) {
            strMeasure3.visibility= View.VISIBLE
            strMeasure3.text = searchDrinksItem.strMeasure3
        } else { strMeasure3.visibility = View.GONE }
        if (!searchDrinksItem.strMeasure4.isNullOrEmpty()) {
            strMeasure4.visibility= View.VISIBLE
            strMeasure4.text = searchDrinksItem.strMeasure4
        } else { strMeasure4.visibility = View.GONE }
        if (!searchDrinksItem.strMeasure5.isNullOrEmpty()) {
            strMeasure5.visibility= View.VISIBLE
            strMeasure5.text = searchDrinksItem.strMeasure5
        } else { strMeasure5.visibility = View.GONE }
        if (!searchDrinksItem.strMeasure6.isNullOrEmpty()) {
            strMeasure6.visibility= View.VISIBLE
            strMeasure6.text = searchDrinksItem.strMeasure6
        } else { strMeasure6.visibility = View.GONE }
        if (!searchDrinksItem.strMeasure7.isNullOrEmpty()) {
            strMeasure7.visibility= View.VISIBLE
            strMeasure7.text = searchDrinksItem.strMeasure7
        } else { strMeasure7.visibility = View.GONE }
        if (!searchDrinksItem.strMeasure8.isNullOrEmpty()) {
            strMeasure8.visibility= View.VISIBLE
            strMeasure8.text = searchDrinksItem.strMeasure8
        } else { strMeasure8.visibility = View.GONE }
        if (!searchDrinksItem.strMeasure9.isNullOrEmpty()) {
            strMeasure9.visibility= View.VISIBLE
            strMeasure9.text = searchDrinksItem.strMeasure9
        } else { strMeasure9.visibility = View.GONE }
    }
    override fun onChanged(error: Error?) {
        error?.let {
            when (it) {
                is EmptyError -> {
                    emptyViewPod=emptyDetail as EmptyViewPod
                    emptyDetail.setBackgroundColor(resources.getColor(R.color.white))
                    emptyViewPod!!.setEmptyData(R.drawable.empty_img,"Product Not Found")
                    emptyDetail.visibility = View.VISIBLE
                }
                is NetworkError ->{
                    emptyViewPod=emptyDetail as EmptyViewPod
                    emptyDetail.setBackgroundColor(resources.getColor(R.color.white))
                    emptyViewPod!!.setEmptyData(R.drawable.nointernet,"No Internet Connection")
                    emptyDetail.visibility = View.VISIBLE
                    showNetworkError(searchDetailLayout, applicationContext, error as NetworkError)
                }
            }
        }
    }
}