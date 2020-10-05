public class Inventory {
    private Object resource[][] = {{"water", 0},
            {"food",0},
            {"wood",0},
            {"stone",0},
            {"stoneSword",0},
            {"stoneAxe",0},
            {"stonePickAxe",0},
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

    Inventory(int water, int food, int wood, int stone, int stoneSword, int stoneAxe, int stonePickAxe, int meat, int fruits) {
        setStone(stone);
        setFood(food);
        setStoneAxe(stoneAxe);
        setStonePickAxe(stonePickAxe);
        setStoneSword(stoneSword);
        setWood(wood);
        setWater(water);
        setResource(meat, 7);
        setResource(fruits, 8);
    }
    //getter & setter

    public Object[][] getResource() {
        return resource;
    }

    public void setWater(int water){
        resource[0][1] = water;
    }
    public void setFood(int food){
        resource[1][1] = food;
    }
    public void setWood(int wood){
        resource[2][1] = wood;
    }
    public void setStone(int stone){
        resource[3][1] = stone;
    }
    public void setStoneSword(int stoneSword){
        resource[4][1] = stoneSword;
    }
    public void setStoneAxe(int stoneAxe){
        resource[5][1] = stoneAxe;
    }
    public void setStonePickAxe(int stonePickAxe){
        resource[6][1] = stonePickAxe;
    }


    //item 번호와 갯수를 받아서 그에 해당하는 아이템 갯수 수정
    public void setResource(int mount, int itemNumber){
        resource[itemNumber][1] = mount;
    }
}