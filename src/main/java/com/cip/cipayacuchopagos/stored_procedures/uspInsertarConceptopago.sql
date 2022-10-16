USE dbCIPAYACUCHO
GO

IF EXISTS (SELECT * FROM sysobjects WHERE type = 'P' AND name = 'uspInsertarConceptopago')
    BEGIN
        DROP PROCEDURE uspInsertarConceptopago
    END
GO

CREATE PROCEDURE uspInsertarConceptopago

@descripcion nvarchar(100),
@fechaCreacion datetime,
@montoUnitario decimal(9,4),
@fechaModificacion datetime,
@estado bit

AS

DECLARE @idConceptoPago int;
SELECT @idConceptoPago =  ISNULL(MAX(idConceptoPago),0)+1 FROM ConceptoPago;

INSERT INTO ConceptoPago (idConceptoPago, descripcion, fechaCreacion, montoUnitario, fechaModificacion, estado)
VALUES (@idConceptoPago, @descripcion, @fechaCreacion, @montoUnitario, @fechaModificacion, @estado)

SELECT MAX(idConceptoPago)
FROM ConceptoPago

GO
