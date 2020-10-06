public class Inventory {
    private Object resource[][] = {
            {"water", 0},
            {"wood",0},
            {"stone",0},
            {"stonesword",0},
            {"stoneaxe",0},
            {"stonepickaxe",0},
            {"meat",0},
            {"fruits",0},
            {"ship0",0},
            {"ship1",0},
            {"ship2",0},
            {"house0",1},
            {"house1",0},
            {"house2",0},
            {"house3",0}
    };
    //counts

    Inventory(int water, int wood, int stone, int stonesword, int stoneaxe, int stonepickaxe, int meat, int fruits
        , int ship0, int ship1, int ship2, int house0, int house1, int house2, int house3){
        setStone(stone);
        setStoneAxe(stoneaxe);
        setStonePickAxe(stonepickaxe);
        setStoneSword(stonesword);
        setWood(wood);
        setWater(water);
        setResource(meat, 6);
        setResource(fruits, 7);
        setResource(ship0, 8);
        setResource(ship1, 9);
        setResource(ship2, 10);
        setResource(house0, 11);
        setResource(house1 ,12);
        setResource(house2, 13);
        setResource(house3,14);

    }
    //getter & setter

    public Object[][] getResource() {
        return resource;
    }

    public void setWater(int water){
        resource[0][1] = water;
    }
    public void setWood(int wood){
        resource[1][1] = wood;
    }
    public void setStone(int stone){
        resource[2][1] = stone;
    }
    public void setStoneSword(int stonesword){
        resource[3][1] = stonesword;
    }
    public void setStoneAxe(int stoneaxe){
        resource[4][1] = stoneaxe;
    }
    public void setStonePickAxe(int stonepickaxe){
        resource[5][1] = stonepickaxe;
    }


    //item 번호와 갯수를 받아서 그에 해당하는 아이템 갯수 수정
    public void setResource(int mount, int itemNumber){
        resource[itemNumber][1] = mount;
    }
}