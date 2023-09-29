import React from 'react'
import axios from 'axios'
import CodexPage from '../../models/CodexPage'
import CodexPageResponse from '../../models/CodexPageResponse'

function PagesPage() {
  const [codexPages, setCodexPages] = React.useState<CodexPage[]>([])

  const getCodexPages = () => {
    axios
      .get<CodexPageResponse>("http://localhost:8080/api/v1/codexPages")
      .then(response => setCodexPages(response.data.data))
      .catch(error => console.log(error))
  }

  React.useEffect(() => {
    getCodexPages()
  }, [])

  return (
    <>
      <div>Codex Pages</div>
      {
        codexPages.map(codexPage => {
          return <div key={codexPage.codexPageId}>{codexPage.title}</div>
        })
      }
    </>
  )
}

export default PagesPage