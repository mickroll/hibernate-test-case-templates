-- federal states
insert into catalog_value(id,"key",displayName) VALUES ('00000001-0000-0000-0000-000000000001','DE-BY','Bayern');
insert into catalog_value(id,"key",displayName) VALUES ('00000001-0000-0000-0000-000000000002','DE-SN','Sachsen');

-- countries
insert into catalog_value(id,"key",displayName) VALUES ('00000001-0000-0001-0000-000000000000','DE','Deutschland');
insert into catalog_value(id,"key",displayName) VALUES ('00000001-0000-0001-0000-000000000001','AT','Österreich');


-- metadata for federal states
insert into catalog_value_metadata(catalog_value_id,"key",is_public,"value") VALUES ('00000001-0000-0000-0000-000000000001','LINK',0,'http://blubb.de');

-- metadata for countries
insert into catalog_value_metadata(catalog_value_id,"key",is_public,"value") VALUES ('00000001-0000-0001-0000-000000000001','LINK',0,'http://bla.de');
