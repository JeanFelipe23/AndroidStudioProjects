package felipe.jean.jokenpo

import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import felipe.jean.jokenpo.R.string.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.Random

class MainActivity : AppCompatActivity() {


    //Dizendo que a variavel Numero Aleatorio puxa o Random e inicia setada como null(Nulo)
    private var numeroAleatorio: Random? = null


    //Setar variaveis antes do Override Fun
    private val PEDRA = 1
    private val PAPEL = 2
    private val TESOURA = 3


    private fun realizarJogada(JogadaPlayer:Int){

        //Criando uma variavel player para buscar o som na pasta Raw
        val player = MediaPlayer.create(this,R.raw.jokenpo)
       //Startando a Funcion
        player.start()

      val jogadaPC = numeroAleatorio!!.nextInt(3)+1

        when (jogadaPC){

            PEDRA -> {
            ivjogadaPC.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.pedra))

            when (JogadaPlayer){
                PAPEL -> venceu()
                PEDRA -> empatou()
                TESOURA -> perdeu()
                }
            }
                   PAPEL -> {
                       ivjogadaPC.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.papel))

                       when (JogadaPlayer) {
                           PAPEL -> empatou()
                           PEDRA -> venceu()
                           TESOURA -> perdeu()

                       }
                   }

            TESOURA -> {
                ivjogadaPC.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.tesoura))

                when (JogadaPlayer){
                    PAPEL -> venceu()
                    PEDRA -> perdeu()
                    TESOURA -> empatou()
                }
          }
        }
      }

 private fun venceu(){

     tvResultado!!.text = getString(R.string.venceu)
     tvResultado!!.setTextColor(ContextCompat.getColor(this,R.color.vitoria))
 }

    private fun perdeu(){

        tvResultado!!.text = getString(R.string.perdeu)
        tvResultado!!.setTextColor(ContextCompat.getColor(this,R.color.derrota))
    }

    private fun empatou(){

        tvResultado!!.text = getString(R.string.empatou)
        tvResultado!!.setTextColor(ContextCompat.getColor(this,R.color.empate))
    }



    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        numeroAleatorio = Random()
        //Estou dizendo que ao tocar no ImagePedra Gera uma açao de
        ivPedra.setOnClickListener {

            //Ao iniciar a açao de jogar a programaçao ira procurar
            // A imagem do objeto escolhido em Drawable
            ivjogadaPlayer!!.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.pedra))
       realizarJogada(PEDRA)
        }
        ivPapel.setOnClickListener {
            ivjogadaPlayer!!.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.papel))
        realizarJogada(PAPEL)
        }
        ivPedra.setOnClickListener {

            ivjogadaPlayer!!.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.tesoura))
            realizarJogada(TESOURA)
        }


    }






}