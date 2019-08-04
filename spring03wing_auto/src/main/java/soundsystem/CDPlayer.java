package soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class CDPlayer {
    @Autowired
    private CompactDisc cd;

    @Autowired
    private  Power power;


    public  CDPlayer(CompactDisc cd, Power power)
    {
        this.cd=cd;
        this.power =power;
        System.out.println("CDPlayer 的多参数构造函数");
    }

    public CDPlayer() {
        super();
        System.out.println("CDPlayer的无参构造函数");
    }

    public CompactDisc getCd() {
        return cd;
    }
    public void CDPlayer(CompactDisc cd) {
        this.cd = cd;
        System.out.println("CDPlayer的有参构造函数");
    }


    @Autowired
    public void play(){
        power.supply();
        cd.play();
    }

}
