PGDMP     
                	    z           postgres    14.5    14.5 +    ?           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            ?           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            ?           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            ?           1262    13754    postgres    DATABASE     d   CREATE DATABASE postgres WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Spanish_Spain.1252';
    DROP DATABASE postgres;
                postgres    false            ?           0    0    DATABASE postgres    COMMENT     N   COMMENT ON DATABASE postgres IS 'default administrative connection database';
                   postgres    false    3471                        2615    16394    pgagent    SCHEMA        CREATE SCHEMA pgagent;
    DROP SCHEMA pgagent;
                postgres    false            ?           0    0    SCHEMA pgagent    COMMENT     6   COMMENT ON SCHEMA pgagent IS 'pgAgent system tables';
                   postgres    false    8                        3079    16384 	   adminpack 	   EXTENSION     A   CREATE EXTENSION IF NOT EXISTS adminpack WITH SCHEMA pg_catalog;
    DROP EXTENSION adminpack;
                   false            ?           0    0    EXTENSION adminpack    COMMENT     M   COMMENT ON EXTENSION adminpack IS 'administrative functions for PostgreSQL';
                        false    2                        3079    16395    pgagent 	   EXTENSION     <   CREATE EXTENSION IF NOT EXISTS pgagent WITH SCHEMA pgagent;
    DROP EXTENSION pgagent;
                   false    8            ?           0    0    EXTENSION pgagent    COMMENT     >   COMMENT ON EXTENSION pgagent IS 'A PostgreSQL job scheduler';
                        false    3            ?            1259    24781    c_area    TABLE     W   CREATE TABLE public.c_area (
    id_area integer NOT NULL,
    nombre text NOT NULL
);
    DROP TABLE public.c_area;
       public         heap    postgres    false            ?            1259    24788    c_area_id_area_seq    SEQUENCE     ?   CREATE SEQUENCE public.c_area_id_area_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 9999999
    CACHE 1;
 )   DROP SEQUENCE public.c_area_id_area_seq;
       public          postgres    false    231            ?           0    0    c_area_id_area_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.c_area_id_area_seq OWNED BY public.c_area.id_area;
          public          postgres    false    232            ?            1259    24804    c_sala    TABLE       CREATE TABLE public.c_sala (
    id_sala integer NOT NULL,
    numero_sala smallint NOT NULL,
    total_asientos integer NOT NULL,
    fecha_alta timestamp without time zone NOT NULL,
    fecha_modificacion timestamp without time zone,
    registro_activo boolean DEFAULT true
);
    DROP TABLE public.c_sala;
       public         heap    postgres    false            ?            1259    16558 
   m_empleado    TABLE     ?   CREATE TABLE public.m_empleado (
    id_empleado bigint NOT NULL,
    nombre text NOT NULL,
    apellido text NOT NULL,
    fecha_nacimiento date NOT NULL,
    activo boolean DEFAULT true,
    id_area integer
);
    DROP TABLE public.m_empleado;
       public         heap    postgres    false            ?            1259    24775    incrementableid    SEQUENCE        CREATE SEQUENCE public.incrementableid
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 999999999
    CACHE 1;
 &   DROP SEQUENCE public.incrementableid;
       public          postgres    false    229            ?           0    0    incrementableid    SEQUENCE OWNED BY     N   ALTER SEQUENCE public.incrementableid OWNED BY public.m_empleado.id_empleado;
          public          postgres    false    230            ?            1259    24796    m_cine    TABLE     ?   CREATE TABLE public.m_cine (
    id_cine integer NOT NULL,
    nombre text NOT NULL,
    fecha_alta timestamp without time zone NOT NULL,
    fecha_modificacion timestamp without time zone NOT NULL,
    registro_activo boolean DEFAULT true NOT NULL
);
    DROP TABLE public.m_cine;
       public         heap    postgres    false            ?            1259    24841    r_cine_sala    TABLE       CREATE TABLE public.r_cine_sala (
    id_cine_sala bigint NOT NULL,
    id_cine integer NOT NULL,
    id_sala integer NOT NULL,
    fecha_alta timestamp without time zone NOT NULL,
    fecha_modificacion timestamp with time zone,
    registro_activo boolean DEFAULT true
);
    DROP TABLE public.r_cine_sala;
       public         heap    postgres    false            ?           2604    24789    c_area id_area    DEFAULT     p   ALTER TABLE ONLY public.c_area ALTER COLUMN id_area SET DEFAULT nextval('public.c_area_id_area_seq'::regclass);
 =   ALTER TABLE public.c_area ALTER COLUMN id_area DROP DEFAULT;
       public          postgres    false    232    231            ?           2604    24790    m_empleado id_empleado    DEFAULT     u   ALTER TABLE ONLY public.m_empleado ALTER COLUMN id_empleado SET DEFAULT nextval('public.incrementableid'::regclass);
 E   ALTER TABLE public.m_empleado ALTER COLUMN id_empleado DROP DEFAULT;
       public          postgres    false    230    229            ?          0    16396    pga_jobagent 
   TABLE DATA           I   COPY pgagent.pga_jobagent (jagpid, jaglogintime, jagstation) FROM stdin;
    pgagent          postgres    false    214   ?,       ?          0    16405    pga_jobclass 
   TABLE DATA           7   COPY pgagent.pga_jobclass (jclid, jclname) FROM stdin;
    pgagent          postgres    false    216   -       ?          0    16415    pga_job 
   TABLE DATA           ?   COPY pgagent.pga_job (jobid, jobjclid, jobname, jobdesc, jobhostagent, jobenabled, jobcreated, jobchanged, jobagentid, jobnextrun, joblastrun) FROM stdin;
    pgagent          postgres    false    218   $-       ?          0    16463    pga_schedule 
   TABLE DATA           ?   COPY pgagent.pga_schedule (jscid, jscjobid, jscname, jscdesc, jscenabled, jscstart, jscend, jscminutes, jschours, jscweekdays, jscmonthdays, jscmonths) FROM stdin;
    pgagent          postgres    false    222   A-       ?          0    16491    pga_exception 
   TABLE DATA           J   COPY pgagent.pga_exception (jexid, jexscid, jexdate, jextime) FROM stdin;
    pgagent          postgres    false    224   ^-       ?          0    16505 
   pga_joblog 
   TABLE DATA           X   COPY pgagent.pga_joblog (jlgid, jlgjobid, jlgstatus, jlgstart, jlgduration) FROM stdin;
    pgagent          postgres    false    226   {-       ?          0    16439    pga_jobstep 
   TABLE DATA           ?   COPY pgagent.pga_jobstep (jstid, jstjobid, jstname, jstdesc, jstenabled, jstkind, jstcode, jstconnstr, jstdbname, jstonerror, jscnextrun) FROM stdin;
    pgagent          postgres    false    220   ?-       ?          0    16521    pga_jobsteplog 
   TABLE DATA           |   COPY pgagent.pga_jobsteplog (jslid, jsljlgid, jsljstid, jslstatus, jslresult, jslstart, jslduration, jsloutput) FROM stdin;
    pgagent          postgres    false    228   ?-       ?          0    24781    c_area 
   TABLE DATA           1   COPY public.c_area (id_area, nombre) FROM stdin;
    public          postgres    false    231   ?-       ?          0    24804    c_sala 
   TABLE DATA           w   COPY public.c_sala (id_sala, numero_sala, total_asientos, fecha_alta, fecha_modificacion, registro_activo) FROM stdin;
    public          postgres    false    234    .       ?          0    24796    m_cine 
   TABLE DATA           b   COPY public.m_cine (id_cine, nombre, fecha_alta, fecha_modificacion, registro_activo) FROM stdin;
    public          postgres    false    233   ?.       ?          0    16558 
   m_empleado 
   TABLE DATA           f   COPY public.m_empleado (id_empleado, nombre, apellido, fecha_nacimiento, activo, id_area) FROM stdin;
    public          postgres    false    229   ?.       ?          0    24841    r_cine_sala 
   TABLE DATA           v   COPY public.r_cine_sala (id_cine_sala, id_cine, id_sala, fecha_alta, fecha_modificacion, registro_activo) FROM stdin;
    public          postgres    false    235   /       ?           0    0    c_area_id_area_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.c_area_id_area_seq', 1, true);
          public          postgres    false    232            ?           0    0    incrementableid    SEQUENCE SET     =   SELECT pg_catalog.setval('public.incrementableid', 9, true);
          public          postgres    false    230            ?           2606    24787    c_area c_area_pkey 
   CONSTRAINT     U   ALTER TABLE ONLY public.c_area
    ADD CONSTRAINT c_area_pkey PRIMARY KEY (id_area);
 <   ALTER TABLE ONLY public.c_area DROP CONSTRAINT c_area_pkey;
       public            postgres    false    231            ?           2606    24811    c_sala c_sala_pkey 
   CONSTRAINT     U   ALTER TABLE ONLY public.c_sala
    ADD CONSTRAINT c_sala_pkey PRIMARY KEY (id_sala);
 <   ALTER TABLE ONLY public.c_sala DROP CONSTRAINT c_sala_pkey;
       public            postgres    false    234            ?           2606    24848    m_cine m_cine_pkey 
   CONSTRAINT     U   ALTER TABLE ONLY public.m_cine
    ADD CONSTRAINT m_cine_pkey PRIMARY KEY (id_cine);
 <   ALTER TABLE ONLY public.m_cine DROP CONSTRAINT m_cine_pkey;
       public            postgres    false    233            ?           2606    16564    m_empleado m_empleado_pkey 
   CONSTRAINT     a   ALTER TABLE ONLY public.m_empleado
    ADD CONSTRAINT m_empleado_pkey PRIMARY KEY (id_empleado);
 D   ALTER TABLE ONLY public.m_empleado DROP CONSTRAINT m_empleado_pkey;
       public            postgres    false    229            ?           2606    24846    r_cine_sala r_cine_sala_pkey 
   CONSTRAINT     d   ALTER TABLE ONLY public.r_cine_sala
    ADD CONSTRAINT r_cine_sala_pkey PRIMARY KEY (id_cine_sala);
 F   ALTER TABLE ONLY public.r_cine_sala DROP CONSTRAINT r_cine_sala_pkey;
       public            postgres    false    235            ?           2606    24791    m_empleado fk_empleado_area    FK CONSTRAINT     ?   ALTER TABLE ONLY public.m_empleado
    ADD CONSTRAINT fk_empleado_area FOREIGN KEY (id_area) REFERENCES public.c_area(id_area) NOT VALID;
 E   ALTER TABLE ONLY public.m_empleado DROP CONSTRAINT fk_empleado_area;
       public          postgres    false    229    3312    231            ?   ?   x?33?0?4202?54?50U04?2??21?34?4?4
q?8?????Yx:?{?q??qqq ?ah      ?      x?????? ? ?      ?      x?????? ? ?      ?      x?????? ? ?      ?      x?????? ? ?      ?      x?????? ? ?      ?      x?????? ? ?      ?      x?????? ? ?      ?      x?3?tL????,.)J,?,K?????? Tp?      ?   /   x?3?4?41?420??50"+0????pq??!F??? ?J?      ?   6   x?3?L??K5?4202?50"+0????p?u????Ø1z\\\ iq      ?   ?   x?}??
?0Dϳ?????6G?x?䲭??@??~}???.sXx;?sA??ѥ.??!/??Yq???
;?wYf?K???0AS?>$W?g??u?d⟇_4i??DL???1?u֞???z??<G???/?P??DD_zJ?      ?      x?????? ? ?     