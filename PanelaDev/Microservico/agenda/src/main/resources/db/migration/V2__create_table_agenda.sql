create table agenda (
	id serial primary key,
	descricao varchar(50),
	data_hora timestamp,
	data_criacao timestamp,
	paciente_id integer,
	constraint fk_agenda_paciente foreign key(paciente_id) references paciente(id)
);