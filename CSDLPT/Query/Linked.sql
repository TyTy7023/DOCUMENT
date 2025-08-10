--- SV1
EXEC sp_addlinkedserver 
    @server = 'SV1',
    @provider = 'MSOLEDBSQL',
    @srvproduct = '',
    @datasrc = 'TYTY\SV1',
    @provstr = 'Server=TYTY\SV1;Database=Clients_HN;Trusted_Connection=no';

-- Gán login (SQL Auth)
EXEC sp_addlinkedsrvlogin 
    @rmtsrvname = 'SV1',
    @useself = 'false',
    @locallogin = NULL,
    @rmtuser = 'sa',
    @rmtpassword = '123'; 

--- SV2
EXEC sp_addlinkedserver 
    @server = 'SV2',
    @provider = 'MSOLEDBSQL',
    @srvproduct = '',
    @datasrc = 'TYTY\SV2',
    @provstr = 'Server=TYTY\SV2;Database=Clients_DN;Trusted_Connection=no';

-- Gán login (SQL Auth)
EXEC sp_addlinkedsrvlogin 
    @rmtsrvname = 'SV2',
    @useself = 'false',
    @locallogin = NULL,
    @rmtuser = 'sa',
    @rmtpassword = '123';

--- SV3
EXEC sp_addlinkedserver 
    @server = 'SV3',
    @provider = 'MSOLEDBSQL',
    @srvproduct = '',
    @datasrc = 'TYTY\SV3',
    @provstr = 'Server=TYTY\SV2;Database=Clients_HCM;Trusted_Connection=no';

-- Gán login (SQL Auth)
EXEC sp_addlinkedsrvlogin 
    @rmtsrvname = 'SV3',
    @useself = 'false',
    @locallogin = NULL,
    @rmtuser = 'sa',
    @rmtpassword = '123'; 