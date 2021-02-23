#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

  @tag
  Feature: Controlador

      @tag1
      Scenario: Buscar un equipo
        Given un equipo con nombre "Equipo 1"
        When busco un equipo por el nombre de "Equipo 1"
        Then me retorna el equipo con el nombre "Equipo 1"

    @tag2
    Scenario: Crear un equipo exitosamente
      Given un nombre "Equipo 1"
      When solicito crear un equipo con el nombre "Equipo 1"
      Then se agrega un equipo vacio con el nombre de "Equipo 1"