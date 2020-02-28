package com.brian.monstermatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.absoluteValue

data class Monster(val head: Int, val body: Int, val feet: Int, val name: String)

class MainActivity : AppCompatActivity() {

    //Single Array method
    private val monsters: List<Monster> = listOf(
        Monster(R.drawable.monster1_head, R.drawable.monster1_body, R.drawable.monster1_feet, "Bill"),
        Monster(R.drawable.monster2_head, R.drawable.monster2_body, R.drawable.monster2_feet, "Tedd"),
        Monster(R.drawable.monster3_head, R.drawable.monster3_body, R.drawable.monster3_feet, "Adventures")
    )

////    Three array method
//    private val heads: List<Int> = listOf(
//        R.drawable.monster1_head,
//        R.drawable.monster2_head,
//        R.drawable.monster3_head
//    )
//    private val bodies: List<Int> = listOf(
//        R.drawable.monster1_body,
//        R.drawable.monster2_body,
//        R.drawable.monster3_body
//    )
//    private val feet: List<Int> = listOf(
//        R.drawable.monster1_feet,
//        R.drawable.monster2_feet,
//        R.drawable.monster3_feet
//    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        shuffleMonsters()
        game_state.setText("Start Game")
        match_button.setOnClickListener {
            shuffleMonsters()

        }
    }

    private fun shuffleMonsters() {
//        //3 array method
//        val headResult = heads.random()
//        val bodyResult = bodies.random()
//        val feetResult = feet.random()
//        monster_head_image_view.setImageResource(headResult)
//        monster_body_image_view.setImageResource(bodyResult)
//        monster_feet_image_view.setImageResource(feetResult)
//
//        var rResult = (0 until 4).random()


//        single list method
        val headResult = monsters.random().head
        val bodyResult = monsters.random().body
        val feetResult = monsters.random().feet
        monster_head_image_view.setImageResource(headResult)
        monster_body_image_view.setImageResource(bodyResult)
        monster_feet_image_view.setImageResource(feetResult)


        for(i in monsters.indices){
            if(monsters[i].head == headResult && monsters[i].body == bodyResult && monsters[i].feet == feetResult) {
                game_state.setText("You matched " + monsters[i].name + "!!!")
                return
            }else{
                game_state.setText("Lose")
            }
        }

    }


}