package com.example.hydragame;

import javafx.scene.image.Image;

public class HydraHeadsFactory {
    private static Image head1 = new Image("file:src/main/resources/com/example/hydragame/HeadSize1.png");
    private static Image head2 = new Image("file:src/main/resources/com/example/hydragame/HeadSize2.png");
    private static Image head3 = new Image("file:src/main/resources/com/example/hydragame/HeadSize3.png");
    private static Image head4 = new Image("file:src/main/resources/com/example/hydragame/HeadSize4.png");
    private static Image head5 = new Image("file:src/main/resources/com/example/hydragame/HeadSize5.png");
    private static Image head6 = new Image("file:src/main/resources/com/example/hydragame/HeadSize6.png");

    private HydraHeadsFactory() {}

        public static HydraHead getHead(int size){
            if (size == 1)
                return new HydraHead(head1, 1);
            else if (size == 2)
                return new HydraHead(head2, 2);
            else if (size == 3)
                return new HydraHead(head3, 3);
            else if (size == 4)
                return new HydraHead(head4, 4);
            else if (size == 5)
                return new HydraHead(head5, 5);
            else if (size == 6)
                return new HydraHead(head6, 6);
            else
                return null;
            }
}