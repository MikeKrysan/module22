package com.appbymikekrysan.module22

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Анимируем кота:
//        val animation = AnimationUtils.loadAnimation(this, R.anim.cat_animation)
//        cat.setOnClickListener{
//            cat.startAnimation(animation)
//        }

//        val animation = AnimationUtils.loadAnimation(this, R.anim.rocket_animation)
//        rocket.setOnClickListener{
//            //По нажатию на данный view и будет проигрываться данная анимация:
//            rocket.startAnimation(animation)
//        }

        //ValueAnimator
//        val animator = ValueAnimator.ofFloat(1f, 0f)  //мы задали от какого к какому значению мы хотим двигаться через лямбду
//        animator.addUpdateListener {
//            //повесли слушателя на наш объект аниматор,
//            rocket.alpha = it.animatedValue as Float   //а в слушателе view устанавливаем прозрачность
//        }
//        animator.duration = 5000 //задаем время выполнения анимации
//        animator.start()    //и в конце стартуем. Анимация происходит при запуске приложения



        //ObjectAnimator
//        ObjectAnimator.ofFloat(rocket, View.ALPHA, 0.1F, 3F).start()


//        AnimationListener - этот интерфейс позволяет получать коллбеки от анимации, связанными с событиями как конец, повтор, старт и отмена анимации

//        val animationUpdateListener = object : Animator.AnimatorListener {
//            override fun onAnimationRepeat(p0: Animator?) {
//                Toast.makeText(this@MainActivity, "Animation repeat", Toast.LENGTH_SHORT).show()
//            }
//            override fun onAnimationEnd(p0: Animator?) {
//                Toast.makeText(this@MainActivity, "Animation End", Toast.LENGTH_SHORT).show()
//            }
//
//            override fun onAnimationCancel(p0: Animator?) {
//                Toast.makeText(this@MainActivity, "Animation cancel", Toast.LENGTH_SHORT).show()
//            }
//
//            override fun onAnimationStart(p0: Animator?) {
//                Toast.makeText(this@MainActivity, "Animation start", Toast.LENGTH_SHORT).show()
//                println("start")
//            }
//
//        }

        //И теперь на определенные события нашей анимации будут выводится Toast:
//        button.setOnClickListener {
//            val anim = ObjectAnimator.ofFloat(rocket, View.TRANSLATION_Y, 0F, -1000F)
//            anim.duration = 1000
//            anim.addListener(animationUpdateListener)
//            anim.start()
//        }


//        button.setOnClickListener {
//            ObjectAnimator.ofFloat(rocket, View.TRANSLATION_Y, 0F, -1000F).start()
//        }


        //Применю ObjectAnimator для кота c добавлением коллбека в мою анимацию (задание 22.3.1)

//        val animationUpdateListener = object : Animator.AnimatorListener {
//            override fun onAnimationRepeat(p0: Animator?) {
//                Toast.makeText(this@MainActivity, "Animation repeat", Toast.LENGTH_SHORT).show()
//            }
//            override fun onAnimationEnd(p0: Animator?) {
//                Toast.makeText(this@MainActivity, "Animation End", Toast.LENGTH_SHORT).show()
//            }
//
//            override fun onAnimationCancel(p0: Animator?) {
//                Toast.makeText(this@MainActivity, "Animation cancel", Toast.LENGTH_SHORT).show()
//            }
//
//            override fun onAnimationStart(p0: Animator?) {
//                Toast.makeText(this@MainActivity, "Animation start", Toast.LENGTH_SHORT).show()
//                println("start")
//            }
//        }
//
//        buttonForCat.setOnClickListener {
//            val anim = ObjectAnimator.ofFloat(cat, View.ROTATION, 360F)
//            anim.duration = 1000
//            anim.addListener(animationUpdateListener)
//            anim.start()
//        }


        //Анимация FrameAnimator. Чтобы запустить такую анимацию, нужно создать экземпляр класса AndroidDrawable вот таким образом:

//        val ad = getResources().getDrawable(R.drawable.frame_animation) as AnimationDrawable
//        //потом кладем этот объект в image view:
//        imageView.setBackgroundDrawable(ad)
//        //и запскаем
//        ad.start()

        //Солнце всходит, тучки появляются:

        val sunAnim = ObjectAnimator.ofFloat(sun, View.TRANSLATION_Y, -1200f)
        sunAnim.duration = 1500

        val nightAnim = ObjectAnimator.ofFloat(screen_night, View.ALPHA, 0f)
        nightAnim.duration = 2000

        val cloud1 = ObjectAnimator.ofFloat(oblako_1, View.TRANSLATION_X, 0F)
        cloud1.duration = 1000

        val cloud2 = ObjectAnimator.ofFloat(oblako_2, View.TRANSLATION_X, 0F)
        cloud2.duration = 1000

        val animatorSun = AnimatorSet()
        animatorSun.playTogether(sunAnim, nightAnim)
        animatorSun.play(cloud1).after(sunAnim)
        animatorSun.play(cloud2).after(sunAnim).after(500)

        animatorSun.start()
    }
}