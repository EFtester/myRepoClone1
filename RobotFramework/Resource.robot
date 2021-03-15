*** Settings ***
Library          SeleniumLibrary    run_on_failure=None
Library          Dialogs
Library          Collections
Library          OperatingSystem
Library          DateTime
Library          String
Resource        ../Resources/Jarvis-SpotfireAutomation-Resource.robot
Resource        ../Resources/Jarvis-General-Keywords.robot

*** Variables ***
${download_path}                  Downloads
${SIGN_IN_BUTTON_LOCATOR}         id = sign_in
&{OPEN_BROWSER_ELEMENTS}          verification_entity=${SIGN_IN_BUTTON_LOCATOR}       page_title=Jarvis - Sign In

*** Keywords ***
Change Browser Options
    [Documentation]               This keyword allows to change chrome browser options
    #Change download directory
    Create Directory              ${download_path}
    ${chrome_options}=            Evaluate                        sys.modules['selenium.webdriver'].ChromeOptions()
    ...                           sys, selenium.webdriver
    ${prefs}                      Create Dictionary               download.default_directory=${download_path}
    Call Method                   ${chrome_options}               add_experimental_option         prefs
    ...                           ${prefs}
    [Return]                      ${chrome_options}

Open Browser on URL
    [Documentation]               This keyword allows to open chrome browser on given url ${url}
    [Arguments]                   ${OPEN_BROWSER_ELEMENTS}        ${url}      ${page_title}
    ${verification_entity}=       Get From Dictionary             ${OPEN_BROWSER_ELEMENTS}        verification_entity
    ${page_title}=                Get From Dictionary             ${OPEN_BROWSER_ELEMENTS}        page_title
    ${chrome_options}=            Run Keyword                     Change Browser Options
    Open Browser	                ${url} 	                        Chrome                          options=${chrome_options}
    Maximize Browser Window
    Title Should Be               ${page_title}
    Page Should Contain Element                                   ${verification_entity}
