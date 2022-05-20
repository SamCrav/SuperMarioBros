/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermariobros;

import mariobros.entity.Entity;

public class Camera {

    public int x, y;

    public void tick(Entity player ){
        if(-player.getX() + Game.WIDTH>0){
            setX(0);
        }
        else{
            setX(-player.getX() + Game.WIDTH);
        }
        setY(-Game.HEIGHT-64);
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
}
