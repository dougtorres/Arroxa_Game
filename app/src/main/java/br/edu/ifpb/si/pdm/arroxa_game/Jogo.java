package br.edu.ifpb.si.pdm.arroxa_game;

import java.util.Random;

/**
 * Created by admin on 17/11/15.
 */
public class Jogo {

    private int min;
    private int max;
    private int secret;

    public Jogo(int min, int max ){

        this.min = min;
        this.max = max;
        this.secret = secretNumber() ;

    }

    private int secretNumber(){

        Random r = new Random();
        int x = r.nextInt(97) + 2;
        return x;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getSecret() {
        return secret;
    }

    public void setSecret(int secret) {
        this.secret = secret;
    }

    public Status chute(int num){



        if(num == secret){

            return Status.GANHOU;

        }else if(num >= this.max){

            return Status.PERDEU;
        }
        else if(num <= this.min){

            return Status.PERDEU;
        }

        else if(num < this.secret){
            this.min = num;

        }

        else if(num > this.secret){
            this.max = num;

        }

        else if(this.min+2 == this.max){
            return Status.PERDEU;
        }
        return Status.TENTAR_DE_NOVO;

    }
}
