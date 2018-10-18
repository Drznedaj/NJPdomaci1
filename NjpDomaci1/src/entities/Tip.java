package entities;

import annotations.Column;
import annotations.Id;
import annotations.Table;

@Table(name = "tipovi")
public class Tip {

    @Id
    @Column(name = "tip_id")
    private String id;
    @Column(name = "tip_naziv")
    private String naziv;

}
