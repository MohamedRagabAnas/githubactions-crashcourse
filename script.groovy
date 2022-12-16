def buildAPP()
{
    echo "Building with Version ${NEW_VERSION}"
}

def testAPP()
{
    echo "Testing..."
}

def deployAPP()
{
    echo "Deploying with Version ${NEW_VERSION}..."
    echo "Deploying version ${params.Version}"
}

return this