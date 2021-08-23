
    create table category (
       id bigint not null auto_increment,
        description varchar(255),
        recipe_id bigint,
        primary key (id)
    ) engine=InnoDB;

    create table ingredient (
       id bigint not null auto_increment,
        amount decimal(19,2),
        description varchar(255),
        recipe_id bigint,
        uom_id bigint,
        primary key (id)
    ) engine=InnoDB;

    create table notes (
       id bigint not null auto_increment,
        recipe_notes longtext,
        recipe_id bigint,
        primary key (id)
    ) engine=InnoDB;

    create table recipe (
       id bigint not null auto_increment,
        cook_time integer,
        description varchar(255),
        difficulty varchar(255),
        directions longtext,
        image longblob,
        prep_time integer,
        servings integer,
        source varchar(255),
        url varchar(255),
        notes_id bigint,
        primary key (id)
    ) engine=InnoDB;

    create table unit_of_measure (
       id bigint not null auto_increment,
        description varchar(255),
        primary key (id)
    ) engine=InnoDB;

    alter table category 
       add constraint FK5drd8ijiy6ikg8swa3gjt4jgw 
       foreign key (recipe_id) 
       references recipe (id);

    alter table ingredient 
       add constraint FKj0s4ywmqqqw4h5iommigh5yja 
       foreign key (recipe_id) 
       references recipe (id);

    alter table ingredient 
       add constraint FK6iv5l89qmitedn5m2a71kta2t 
       foreign key (uom_id) 
       references unit_of_measure (id);

    alter table notes 
       add constraint FKdbfsiv21ocsbt63sd6fg0t3c8 
       foreign key (recipe_id) 
       references recipe (id);

    alter table recipe 
       add constraint FK37al6kcbdasgfnut9xokktie9 
       foreign key (notes_id) 
       references notes (id);
