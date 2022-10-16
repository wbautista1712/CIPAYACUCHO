USE dbCIPAYACUCHO
GO

IF EXISTS (SELECT * FROM sysobjects WHERE type = 'P' AND name = 'uspActualizarConceptopago')
    BEGIN
        DROP PROCEDURE uspActualizarConceptopago
    END
GO

CREATE PROCEDURE uspActualizarConceptopago

@idConceptoPago int,
@descripcion nvarchar(100),
@fechaCreacion datetime,
@montoUnitario decimal(9,4),
@fechaModificacion datetime,
@estado bit

AS

UPDATE ConceptoPago SET idConceptoPago = @idConceptoPago, descripcion = @descripcion, fechaCreacion = @fechaCreacion, montoUnitario = @montoUnitario, fechaModificacion = @fechaModificacion, estado = @estado
WHERE idConceptoPago = @idConceptoPago

GO
