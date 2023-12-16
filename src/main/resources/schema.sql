CREATE TABLE CAMPAIGN (
    id INT AUTO_INCREMENT PRIMARY KEY,
    game VARCHAR(255),
    name VARCHAR(255),
    priority DOUBLE,
    start_date TIMESTAMP,
    end_date TIMESTAMP,
    enabled BOOLEAN,
    last_updated TIMESTAMP
);

CREATE TABLE CLAN (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE PLAYER (
    id INT AUTO_INCREMENT PRIMARY KEY,
    player_id VARCHAR(255) NOT NULL,
    credential VARCHAR(255),
    created TIMESTAMP,
    modified TIMESTAMP,
    last_session TIMESTAMP,
    total_spent INT,
    total_refund INT,
    total_transactions INT,
    last_purchase TIMESTAMP,
    active_campaigns VARCHAR(255),
    level INT,
    xp INT,
    total_playtime INT,
    country VARCHAR(255),
    language VARCHAR(255),
    birthdate TIMESTAMP,
    gender VARCHAR(255),
    custom_field VARCHAR(255),
    clan_id INT,
    FOREIGN KEY (clan_id) REFERENCES CLAN(id)
);



CREATE TABLE DEVICE (
    id INT AUTO_INCREMENT PRIMARY KEY,
    model VARCHAR(255),
    carrier VARCHAR(255),
    firmware VARCHAR(255),
    player_id INT,
    FOREIGN KEY (player_id) REFERENCES PLAYER(id)
);

CREATE TABLE PLAYER_INVENTORY (
    player_id INT,
    item_name VARCHAR(255),
    item_quantity INT,
    FOREIGN KEY (player_id) REFERENCES PLAYER(id)
);

CREATE TABLE PLAYER_COUNTRY (
    player_id INT,
    country VARCHAR(255),
    FOREIGN KEY (player_id) REFERENCES PLAYER(id)
);

CREATE TABLE PLAYER_ITEM (
    player_id INT,
    item VARCHAR(255),
    FOREIGN KEY (player_id) REFERENCES PLAYER(id)
);


