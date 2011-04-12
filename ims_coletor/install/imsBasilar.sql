--
-- PostgreSQL database dump
--

-- Started on 2010-04-16 08:41:41 BRT

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = off;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET escape_string_warning = off;

SET search_path = public, pg_catalog;

--
-- TOC entry 1504 (class 1259 OID 16386)
-- Dependencies: 5
-- Name: servicos_sequence; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE servicos_sequence
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 1824 (class 0 OID 0)
-- Dependencies: 1504
-- Name: servicos_sequence; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('servicos_sequence', 15, true);


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 1505 (class 1259 OID 16388)
-- Dependencies: 1791 5
-- Name: servicos; Type: TABLE; Schema: public; Owner: -; Tablespace: 
--

CREATE TABLE servicos (
    id integer DEFAULT nextval('servicos_sequence'::regclass) NOT NULL,
    nome character varying(30),
    mib character varying(30)
);


--
-- TOC entry 1506 (class 1259 OID 16392)
-- Dependencies: 5
-- Name: servidor_has_servicos; Type: TABLE; Schema: public; Owner: -; Tablespace: 
--

CREATE TABLE servidor_has_servicos (
    servidor_id integer NOT NULL,
    servico_id integer NOT NULL
);


--
-- TOC entry 1507 (class 1259 OID 16395)
-- Dependencies: 5
-- Name: servidores_sequence; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE servidores_sequence
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 1825 (class 0 OID 0)
-- Dependencies: 1507
-- Name: servidores_sequence; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('servidores_sequence', 1, true);


--
-- TOC entry 1508 (class 1259 OID 16397)
-- Dependencies: 1792 5
-- Name: servidores; Type: TABLE; Schema: public; Owner: -; Tablespace: 
--

CREATE TABLE servidores (
    id integer DEFAULT nextval('servidores_sequence'::regclass) NOT NULL,
    ip character varying(15) NOT NULL,
    community character varying(15) NOT NULL
);


--
-- TOC entry 1509 (class 1259 OID 16401)
-- Dependencies: 5
-- Name: servidores_has_usuarios; Type: TABLE; Schema: public; Owner: -; Tablespace: 
--

CREATE TABLE servidores_has_usuarios (
    servidor_id integer NOT NULL,
    usuarios_id integer NOT NULL
);


--
-- TOC entry 1512 (class 1259 OID 16455)
-- Dependencies: 5
-- Name: status_sequence; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE status_sequence
    START WITH 15
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 1826 (class 0 OID 0)
-- Dependencies: 1512
-- Name: status_sequence; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('status_sequence', 15, false);


--
-- TOC entry 1513 (class 1259 OID 16457)
-- Dependencies: 1794 5
-- Name: status; Type: TABLE; Schema: public; Owner: -; Tablespace: 
--

CREATE TABLE status (
    id_servidor integer DEFAULT nextval('status_sequence'::regclass) NOT NULL,
    id_servico integer,
    status character varying(100),
    horario timestamp without time zone,
    id integer NOT NULL
);


--
-- TOC entry 1510 (class 1259 OID 16404)
-- Dependencies: 5
-- Name: usuarios_sequence; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE usuarios_sequence
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 1827 (class 0 OID 0)
-- Dependencies: 1510
-- Name: usuarios_sequence; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('usuarios_sequence', 1, true);


--
-- TOC entry 1511 (class 1259 OID 16406)
-- Dependencies: 1793 5
-- Name: usuarios; Type: TABLE; Schema: public; Owner: -; Tablespace: 
--

CREATE TABLE usuarios (
    id integer DEFAULT nextval('usuarios_sequence'::regclass) NOT NULL,
    nome character varying(45),
    usuario character varying(45),
    senha character varying(20)
);


--
-- TOC entry 1813 (class 0 OID 16388)
-- Dependencies: 1505
-- Data for Name: servicos; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO servicos (id, nome, mib) VALUES (1, 'memTotalSwap', '.1.3.6.1.4.1.2021.4.4.0');
INSERT INTO servicos (id, nome, mib) VALUES (2, 'memAvailSwap', '.1.3.6.1.4.1.2021.4.5.0');
INSERT INTO servicos (id, nome, mib) VALUES (3, 'memTotalReal', '.1.3.6.1.4.1.2021.4.6.0');
INSERT INTO servicos (id, nome, mib) VALUES (4, 'memAvailReal', '.1.3.6.1.4.1.2021.4.11.0');
INSERT INTO servicos (id, nome, mib) VALUES (5, 'memTotalFree', '.1.3.6.1.4.1.2021.4.12.0');
INSERT INTO servicos (id, nome, mib) VALUES (7, 'laLoad.1', '.1.3.6.1.4.1.2021.10.1.3.1');
INSERT INTO servicos (id, nome, mib) VALUES (8, 'laLoad.2', '.1.3.6.1.4.1.2021.10.1.3.2');
INSERT INTO servicos (id, nome, mib) VALUES (9, 'laLoad.3', '.1.3.6.1.4.1.2021.10.1.3.3');
INSERT INTO servicos (id, nome, mib) VALUES (6, 'ipAdEntAddr', '.1.3.6.1.2.1.4.20.1.2');
INSERT INTO servicos (id, nome, mib) VALUES (10, 'sysContact', '.1.3.6.1.2.1.1.4.0');


--
-- TOC entry 1814 (class 0 OID 16392)
-- Dependencies: 1506
-- Data for Name: servidor_has_servicos; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO servidor_has_servicos (servidor_id, servico_id) VALUES (1, 1);
INSERT INTO servidor_has_servicos (servidor_id, servico_id) VALUES (1, 2);
INSERT INTO servidor_has_servicos (servidor_id, servico_id) VALUES (1, 3);


--
-- TOC entry 1815 (class 0 OID 16397)
-- Dependencies: 1508
-- Data for Name: servidores; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO servidores (id, ip, community) VALUES (1, '127.0.0.1', 'public');


--
-- TOC entry 1816 (class 0 OID 16401)
-- Dependencies: 1509
-- Data for Name: servidores_has_usuarios; Type: TABLE DATA; Schema: public; Owner: -
--



--
-- TOC entry 1818 (class 0 OID 16457)
-- Dependencies: 1513
-- Data for Name: status; Type: TABLE DATA; Schema: public; Owner: -
--



--
-- TOC entry 1817 (class 0 OID 16406)
-- Dependencies: 1511
-- Data for Name: usuarios; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO usuarios (id, nome, usuario, senha) VALUES (1, 'Fábio', 'fabio', '1234');


--
-- TOC entry 1806 (class 2606 OID 16462)
-- Dependencies: 1513 1513
-- Name: id; Type: CONSTRAINT; Schema: public; Owner: -; Tablespace: 
--

ALTER TABLE ONLY status
    ADD CONSTRAINT id PRIMARY KEY (id);


--
-- TOC entry 1796 (class 2606 OID 16411)
-- Dependencies: 1505 1505
-- Name: servicos_pkey; Type: CONSTRAINT; Schema: public; Owner: -; Tablespace: 
--

ALTER TABLE ONLY servicos
    ADD CONSTRAINT servicos_pkey PRIMARY KEY (id);


--
-- TOC entry 1798 (class 2606 OID 16413)
-- Dependencies: 1506 1506 1506
-- Name: servidor_has_servicos_pkey; Type: CONSTRAINT; Schema: public; Owner: -; Tablespace: 
--

ALTER TABLE ONLY servidor_has_servicos
    ADD CONSTRAINT servidor_has_servicos_pkey PRIMARY KEY (servidor_id, servico_id);


--
-- TOC entry 1802 (class 2606 OID 16415)
-- Dependencies: 1509 1509 1509
-- Name: servidores_has_usuarios_pkey; Type: CONSTRAINT; Schema: public; Owner: -; Tablespace: 
--

ALTER TABLE ONLY servidores_has_usuarios
    ADD CONSTRAINT servidores_has_usuarios_pkey PRIMARY KEY (servidor_id, usuarios_id);


--
-- TOC entry 1800 (class 2606 OID 16417)
-- Dependencies: 1508 1508
-- Name: servidores_pkey; Type: CONSTRAINT; Schema: public; Owner: -; Tablespace: 
--

ALTER TABLE ONLY servidores
    ADD CONSTRAINT servidores_pkey PRIMARY KEY (id);


--
-- TOC entry 1804 (class 2606 OID 16419)
-- Dependencies: 1511 1511
-- Name: usuarios_pkey; Type: CONSTRAINT; Schema: public; Owner: -; Tablespace: 
--

ALTER TABLE ONLY usuarios
    ADD CONSTRAINT usuarios_pkey PRIMARY KEY (id);


--
-- TOC entry 1811 (class 2606 OID 16463)
-- Dependencies: 1795 1505 1513
-- Name: id_servico; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY status
    ADD CONSTRAINT id_servico FOREIGN KEY (id_servico) REFERENCES servicos(id);


--
-- TOC entry 1812 (class 2606 OID 16468)
-- Dependencies: 1508 1513 1799
-- Name: id_servidor; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY status
    ADD CONSTRAINT id_servidor FOREIGN KEY (id_servidor) REFERENCES servidores(id);


--
-- TOC entry 1807 (class 2606 OID 16420)
-- Dependencies: 1505 1506 1795
-- Name: servidor_has_servicos_servico_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY servidor_has_servicos
    ADD CONSTRAINT servidor_has_servicos_servico_id_fkey FOREIGN KEY (servico_id) REFERENCES servicos(id);


--
-- TOC entry 1808 (class 2606 OID 16425)
-- Dependencies: 1508 1799 1506
-- Name: servidor_has_servicos_servidor_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY servidor_has_servicos
    ADD CONSTRAINT servidor_has_servicos_servidor_id_fkey FOREIGN KEY (servidor_id) REFERENCES servidores(id);


--
-- TOC entry 1809 (class 2606 OID 16430)
-- Dependencies: 1509 1799 1508
-- Name: servidores_has_usuarios_servidor_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY servidores_has_usuarios
    ADD CONSTRAINT servidores_has_usuarios_servidor_id_fkey FOREIGN KEY (servidor_id) REFERENCES servidores(id);


--
-- TOC entry 1810 (class 2606 OID 16435)
-- Dependencies: 1509 1511 1803
-- Name: servidores_has_usuarios_usuarios_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY servidores_has_usuarios
    ADD CONSTRAINT servidores_has_usuarios_usuarios_id_fkey FOREIGN KEY (usuarios_id) REFERENCES usuarios(id);


--
-- TOC entry 1823 (class 0 OID 0)
-- Dependencies: 5
-- Name: public; Type: ACL; Schema: -; Owner: -
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM ims3;
GRANT ALL ON SCHEMA public TO ims3;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2010-04-16 08:41:41 BRT

--
-- PostgreSQL database dump complete
--

